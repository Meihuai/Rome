package com.example.registration.controller;

import com.example.registration.dto.NodeReqeust;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: registration
 * @description: 注册服务
 * @author: meihua
 * @created: 2020/11/27 11:22
 */
@RequestMapping("/api")
@Controller
public class RegistrationController {

    @RequestMapping("/addServer")
    public boolean addService(HttpServletRequest request, NodeReqeust reqeust){




        return true;
    }


}
