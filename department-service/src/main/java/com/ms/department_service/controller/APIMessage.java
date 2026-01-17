package com.ms.department_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class APIMessage {

    @Value("${spring.boot.message}")
    String message;

    @GetMapping("users/message")
    public String getMessage(){
        return message;
    }
}
