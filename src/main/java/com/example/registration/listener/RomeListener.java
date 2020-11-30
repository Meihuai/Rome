package com.example.registration.listener;

import com.example.registration.config.ServerConfig;
import com.example.registration.domain.MasterServer;
import com.example.registration.domain.NodeServer;
import com.example.registration.exception.RomeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: registration
 * @description: 全局服务监听器
 * @author: meihua
 * @created: 2020/11/27 17:21
 */
public class RomeListener {
    private static final Logger logger = LoggerFactory.getLogger(RomeListener.class);

    @Autowired
    private ServerConfig serverConfig;

    /**
     * 集群地址
     **/
    @Value("${rome.address}")
    private String serverAddress;

    @Value("${rome.service.count:1024}")
    private static Integer serviceNum;

    /**
     * 本机ip与端口 默认不配置自动获取
     **/
    @Value("${rome.local.addres:}")
    private String localAddres;

    /**
     * 服务器列表
     **/
    public static List<NodeServer> servers;

    public static   Map<String, MasterServer> serviceMap =new HashMap<>(serviceNum);

    /**
     *推送监听线程池
     **/
    private ThreadPool threadPool;

    /**
     * 核心线程数
     */
    private static final Integer CORENUM=5;

    /**
     *  集群 ip 初始化到 servers
     **/
    private void initServers() throws RomeException {
        if(serverAddress==null||serverAddress==""){
            throw new RomeException("serverAdderss error ！");
        }
        String [] urls = serverAddress.split(",");
        servers=new ArrayList<>(urls.length);
        for (String url:urls){
            NodeServer nodeServer = toNodeServer(url);
            if (nodeServer==null){
                throw new RomeException(" ip  null ！");
            }
            servers.add(nodeServer);
        }
        logger.info("serverAddress init end ",serverAddress.toString());
    }


    public void init() throws RomeException {
        initServers();
        //开始选举  使用默认选举法 根据ID大小 进行通信 半数以上节点通过 则成功  失败则依次轮询
        if(raftVote()){
            //选举成功 开辟线程负责所有子节点的监听与通知
        }

        //

    }

    /**
     * Raft算法
     **/
    public boolean raftVote() throws RomeException {
        //本机节点
        NodeServer localServer = toNodeServer(localAddres);
        if (localServer==null){
            localServer=new NodeServer(serverConfig.getUrl(),serverConfig.getServerPort(),true);
        }
        //根据序号开始轮询投票机制
        for (int i=0;i<servers.size();i++){
             if (servers.get(i).getUrl()==localServer.getUrl()){
                //是自己开始准备接收

                 return true;
             }else {
                //不是自己 开始投票

             }
        }


        return false;
    }



    public void destroy() {

    }

    public NodeServer toNodeServer(String url) throws RomeException {
        if (url==null||url==""){
            return null;
        }
        try {
            URI uri = new URI(url);
            NodeServer nodeServer=new NodeServer(uri.getHost(),uri.getPort(),true);
            return nodeServer;
        } catch (Exception e) {
            logger.error("to ip error url :{}, Exception :{}",url, e);
            throw new RomeException(" ip  error ！");
        }
    }


}
