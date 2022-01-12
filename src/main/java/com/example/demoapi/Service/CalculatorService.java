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

    public int runCalculator(ObjectNode objectNode) {
        int num1 = objectNode.get("num1").asInt();
        int num2 = objectNode.get("num2").asInt();
        String operator = objectNode.get("operator").asText();
        int result = 0;

        try {
            result = determineOperator(num1, num2, operator, result);
        } catch (Exception e) {
            LOGGER.error("Operator used: {}  was invalid. at runCalculator()", operator);
        }

        return result;
    }

    private int determineOperator(int num1, int num2, String operator, int result) throws Exception {
        switch (operator) {
            case "+":
                return calculator.addNumbers(num1, num2);

            case "-":
                return calculator.subtractNumbers(num1, num2);

            case "*":
                return calculator.multipyNumbers(num1, num2);

            case "/":
                return calculator.divideNumbers(num1, num2);

            case "%":
                return calculator.remainderNumbers(num1, num2);

            case "^":
                return calculator.exponentNumbers(num1, num2);

            default:
                LOGGER.error("invalid operator in determineOperator()");
                throw new Exception();
        }
    }
}
