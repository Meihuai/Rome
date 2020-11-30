package com.example.registration.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
 
import java.net.InetAddress;
import java.net.UnknownHostException;
 
/**
 * @author humeihua
 * 获取服务ip与端口
 */
@Component
public class ServerConfig  implements ApplicationListener<WebServerInitializedEvent> {

    @Value("${server.port}")
    private int serverPort;
 
    public String getUrl() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return address.getHostAddress();
    }

    public  int getServerPort(){
        return this.serverPort;
    }
 
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        int port = event.getWebServer().getPort();
           if (port!=0){
               serverPort=port;
           }
    }
 
}