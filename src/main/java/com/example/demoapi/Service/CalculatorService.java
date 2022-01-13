package com.example.demoapi.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorService.class);

    CalculatorServiceHelper calculator;

    public CalculatorService() {
        calculator = new CalculatorServiceHelper();
    }

    public double runCalculator(ObjectNode objectNode) {
        LOGGER.info("Reached runCalculator with properties receieved: num1 {}, num2 {}, operator {}",
                objectNode.get("num1").asDouble(), objectNode.get("num2").asDouble(),
                objectNode.get("operator").asText());
        double num1 = objectNode.get("num1").asDouble();
        double num2 = objectNode.get("num2").asDouble();
        String operator = objectNode.get("operator").asText();
        double result = 0;

        try {
            result = determineOperator(num1, num2, operator);
            LOGGER.info("Result determined successfully: {}", result);
        } catch (Exception e) {
            LOGGER.info("Calculator Failed");
        }

        return result;
    }

    private double determineOperator(double num1, double num2, String operator) throws Exception {
        switch (operator) {
            case "+":
                LOGGER.info("Adding numbers...");
                return calculator.addNumbers(num1, num2);

            case "-":
                LOGGER.info("Subtracting numbers...");
                return calculator.subtractNumbers(num1, num2);

            case "*":
                LOGGER.info("Multiplying numbers...");
                return calculator.multipyNumbers(num1, num2);

            case "/":
                LOGGER.info("Dividing numbers...");
                return calculator.divideNumbers(num1, num2);

            case "%":
                LOGGER.info("Getting the remainder...");
                return calculator.remainderNumbers(num1, num2);

            case "^":
                LOGGER.info("Exponenting numbers...");
                return calculator.exponentNumbers(num1, num2);
            default:
                LOGGER.error("Operator used: {} is invalid at determineOperator()", operator);
                throw new Exception();
        }

    }
}
