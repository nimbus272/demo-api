package com.example.demoapi.Service;

public class CalculatorServiceHelper {

    public int addNumbers(int num1, int num2) {
        return num1 + num2;
    }

    public int divideNumbers(int num1, int num2) {
        return num1 / num2;
    }

    public int exponentNumbers(int num1, int num2) {
        return (int) Math.pow((double) num1, (double) num2);
    }

    public int multipyNumbers(int num1, int num2) {
        return num1 * num2;
    }

    public int remainderNumbers(int num1, int num2) {
        return num1 % num2;
    }

    public int subtractNumbers(int num1, int num2) {
        return num1 - num2;
    }

}
