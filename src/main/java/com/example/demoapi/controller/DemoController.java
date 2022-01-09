package com.example.demoapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String demoEndpoint() {
        return "Hey buddy";
    }
    
}
