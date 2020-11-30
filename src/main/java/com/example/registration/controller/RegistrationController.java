package com.example.registration.controller;

import com.example.registration.domain.Result;
import com.example.registration.domain.RetCode;
import com.example.registration.dto.NodeReqeust;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public Result addService(@RequestBody NodeReqeust reqeust){
        return new Result(RetCode.SUCCESS.code,true,"请求成功！");
    }


}
