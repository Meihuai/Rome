package com.example.registration.domain;

import javax.xml.soap.Node;
import java.util.List;

/**
 * @program: registration
 * @description: 服务
 * @author: meihua
 * @created: 2020/11/27 11:19
 */
public class MasterServer {

    private String name;
    private String appId;
    private List<Node> nodeList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppId() { return appId; }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public List<Node> getNodeList() { return nodeList; }

    public void setNodeList(List<Node> nodeList) { this.nodeList = nodeList; }
}
