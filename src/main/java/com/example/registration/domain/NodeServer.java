package com.example.registration.domain;

/**
 * @program: registration
 * @description: 服务节点类
 * @author: meihua
 * @created: 2020/11/27 11:16
 */
public class NodeServer {

    private String ip;
    private String port;
    private boolean state;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
