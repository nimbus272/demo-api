package com.example.demoapi.Service;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;

public class CalculatorServiceHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorServiceHelper.class);

    public double addNumbers(double num1, double num2) {
        return num1 + num2;
    }

    public double divideNumbers(double num1, double num2) throws NullPointerException {
        if (num2 == 0) {
            LOGGER.error("ERROR: divide by zero");
            throw new ArithmeticException("Error: divide by zero");
        } else {
            return num1 / num2;
        }
    }

    public double exponentNumbers(double num1, double num2) {
        return Math.pow(num1, num2);
    }

    public double multipyNumbers(double num1, double num2) {
        return num1 * num2;
    }

    public double remainderNumbers(double num1, double num2) {
        return num1 % num2;
    }

    public double subtractNumbers(double num1, double num2) {
        return num1 - num2;
    }

}
