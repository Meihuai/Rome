package com.example.registration.service;

import com.example.registration.domain.MasterServer;
import com.example.registration.domain.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: registration
 * @description:
 * @author: meihua
 * @created: 2020/11/27 17:53
 */
@Service
public class RomeServerService {

    public Result receiveServiceConfig(List<MasterServer> masterServers){

        return new Result();
    }

}
