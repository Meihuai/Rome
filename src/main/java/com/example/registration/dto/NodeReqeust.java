package com.example.registration.dto;

/**
 * @program: registration
 * @description:
 * @author: meihua
 * @created: 2020/11/27 11:30
 */
public class NodeReqeust {

    private String appId;
    private String ip;
    private String port;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

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


}
