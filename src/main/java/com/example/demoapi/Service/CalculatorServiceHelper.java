package com.example.demoapi.Service;

import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.slf4j.Logger;

public class CalculatorServiceHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorServiceHelper.class);

    public BigDecimal determineOperator(BigDecimal num1, BigDecimal num2, String operator) throws Exception {
        switch (operator) {
            case "+":
                LOGGER.info("Adding numbers...");
                return num1.add(num2);
            case "-":
                LOGGER.info("Subtracting numbers...");
                return num1.subtract(num2);

            case "*":
                LOGGER.info("Multiplying numbers...");
                return num1.multiply(num2);

            case "/":
                MathContext mc = new MathContext(3, RoundingMode.HALF_UP);
                LOGGER.info("Dividing numbers...");
                if (num2.compareTo(BigDecimal.ZERO) == 0) {
                    LOGGER.error("ERROR: divide by zero");
                    throw new ArithmeticException("Error: divide by zero");
                } else {
                    return num1.divide(num2, mc);
                }

            case "%":
                LOGGER.info("Getting the remainder...");
                return num1.remainder(num2);

            case "^":
                LOGGER.info("Exponenting numbers...");
                if (num2.scale() <= 0 || num2.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
                    return num1.pow(num2.intValue());
                }
                LOGGER.error("Exponent provided must be a whole number");
                throw new ArithmeticException();

            default:
                LOGGER.error("Operator used: {} is invalid at determineOperator()", operator);
                throw new Exception();
        }

    }

}
