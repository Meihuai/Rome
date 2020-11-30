package com.example.registration.domain;

/**
 * @program: registration
 * @description: 服务节点类
 * @author: meihua
 * @created: 2020/11/27 11:16
 */
public class NodeServer {

    private String ip;
    private int port;
    private boolean state;

    public NodeServer(String ip, int port, boolean state) {
        this.ip = ip;
        this.port = port;
        this.state = state;
    }

    public String url(){
        return ip+":"+port;
    }

    public NodeServer() {
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "NodeServer{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", state=" + state +
                '}';
    }
}
