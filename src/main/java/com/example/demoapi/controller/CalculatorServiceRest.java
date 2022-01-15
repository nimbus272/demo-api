package com.example.demoapi.controller;

import com.example.demoapi.Service.CalculatorService;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()
@RestController
public class CalculatorServiceRest {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorServiceRest.class);

    CalculatorService service = new CalculatorService();

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String demoEndpoint() {

        return "push test";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/calculator")
    public ResponseEntity<Object> calculator(@RequestBody ObjectNode objectNode) {
        try {
            double result = service.runCalculator(objectNode);
            LOGGER.info("Result determined: {}", result);
            return ResponseHandler.generateResponse("Successfully performed calculation!", HttpStatus.OK,
                    result);
        } catch (NullPointerException e) {
            LOGGER.error("Error: Null Pointer Exception in RestController");
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }

    }

}
