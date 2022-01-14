package com.braindata.dubbodemo.controller;

import com.braindata.dubbodemo.intf.StuRpcService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/pay")
public class PayController {

    @DubboReference(version = "1.0.0",group = "dubbo-demo", protocol = "dubbo")
    StuRpcService stuRpcService;


    @GetMapping(value = "/toPay")
    public String pay(
            @RequestParam(name = "a", required = false) Integer a,
            @RequestParam(name = "b", required = false) Integer b
            ){

        int c = stuRpcService.add(Optional.ofNullable(a).orElse(0), Optional.ofNullable(b).orElse(0));
        return "success!" + c;
    }
}
