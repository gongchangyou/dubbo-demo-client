package com.braindata.dubbodemo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.braindata.dubbodemo.intf.StuRpcService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pay")
public class PayController {

    @Reference
    StuRpcService stuRpcService;


    @GetMapping(value = "/toPay")
    public String pay(){
        int a = stuRpcService.add(3,4);
        return "success!";
    }
}
