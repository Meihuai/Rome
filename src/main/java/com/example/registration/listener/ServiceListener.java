package com.example.registration.listener;

import com.example.registration.domain.NodeServer;
import com.example.registration.exception.RomeException;
import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: registration
 * @description: 服务监听器
 * @author: meihua
 * @created: 2020/11/27 11:26
 */
public class ServiceListener {

    /**
     * 集群地址
     **/
    @Value("${rome.address}")
    private String serverAddress;

    /**
     * 本机节点
     **/
    private String localAdders;

    /**
     * 服务器列表
     **/
    private List<NodeServer>  servers;

    /*
     *推送监听线程池
     **/
    private ThreadPool threadPool;

    private static final Integer CORENUM=5;

    private void initServers() throws RomeException {
        if(serverAddress==null||serverAddress==""){
            throw new RomeException("serverAdderss error ！");
        }
       String [] strs = serverAddress.split(",");
        for (String str:strs){

        }
    }


    public void init() throws RomeException {
        initServers();



    }

    /**
     * Raft算法
     **/
    public boolean raftVote(){

      return true;
    }



    public void destroy() {

    }

}
