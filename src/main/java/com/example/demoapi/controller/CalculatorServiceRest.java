package com.example.demoapi.controller;

import java.math.BigDecimal;

import com.example.demoapi.Service.CalculatorService;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorServiceRest {

    CalculatorService service = new CalculatorService();

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String demoEndpoint() {
        return "push test";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/calculator")
    public BigDecimal calculator(@RequestBody ObjectNode objectNode) {
        return service.runCalculator(objectNode);
    }

}
