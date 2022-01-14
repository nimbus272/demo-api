package com.example.demoapi.Service;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorService.class);

    CalculatorServiceHelper calculator;

    public CalculatorService() {
        calculator = new CalculatorServiceHelper();
    }

    public BigDecimal runCalculator(ObjectNode objectNode) {
        LOGGER.info("Reached runCalculator with properties receieved: num1 {}, num2 {}, operator {}",
                objectNode.get("num1").asDouble(), objectNode.get("num2").asDouble(),
                objectNode.get("operator").asText());
        BigDecimal num1 = BigDecimal.valueOf(objectNode.get("num1").asDouble());
        BigDecimal num2 = BigDecimal.valueOf(objectNode.get("num2").asDouble());
        String operator = objectNode.get("operator").asText();
        BigDecimal result = null;

        try {
            result = calculator.determineOperator(num1, num2, operator);
            LOGGER.info("Result determined successfully: {}", result);
        } catch (Exception e) {
            LOGGER.info("Calculator Failed");
        }
        if (result == null) {
            LOGGER.error("Method determineOperator() failed. Args: {} {} {}", num1.toString(), num2.toString(),
                    operator);
            throw new NullPointerException();
        }
        return result;
    }
}
