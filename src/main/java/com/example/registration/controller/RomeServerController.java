package com.example.registration.controller;

import com.example.registration.domain.MasterServer;
import com.example.registration.domain.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: registration
 * @description: 服务端
 * @author: meihua
 * @created: 2020/11/27 12:49
 */
@Controller
@RequestMapping("/api")
public class RomeServerController {


   /**
    * @Author meihua
    * @Description 接收来自其他注册中心更新的服务配置
    * @Date 17:43 2020/11/27
    * @Param
    * @return
    **/

    @RequestMapping("/refresh_service_config")
    public Result receiveServiceConfig(@RequestParam List<MasterServer> masterServers){

        return new Result();
    }

    /**
     * @Author meihua
     * @Description 接收来自其他注册中心更新集群配置
     * @Date 17:46 2020/11/27
     * @Param
     * @return
     **/
    @RequestMapping("/refresh_server_config")
    public Result receiveServerConfig(@RequestParam List<MasterServer> masterServers){

        return new Result();
    }


}
