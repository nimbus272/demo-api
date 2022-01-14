package com.example.demoapi.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceHelperTest {

    private CalculatorServiceHelper helper;

    @BeforeEach
    void setUp() {
        helper = new CalculatorServiceHelper();
    }

    @Test
    void testDetermineOperator_Addition() {
        BigDecimal actual = null;
        try {
            actual = helper.determineOperator(BigDecimal.valueOf(6.8), BigDecimal.valueOf(14.54), "+");
        } catch (Exception e) {
            System.out.println("test failed");
        }

        assertEquals(BigDecimal.valueOf(21.34), actual, "Regular addition should work");
    }

    @Test
    void testDetermineOperator_Subtraction() {
        BigDecimal actual = null;
        try {
            actual = helper.determineOperator(BigDecimal.valueOf(18.44), BigDecimal.valueOf(4.9), "-");
        } catch (Exception e) {
            System.out.println("test failed");
        }

        assertEquals(BigDecimal.valueOf(13.54), actual);
    }

    @Test
    void testDetermineOperator_Multiplication() {
        BigDecimal actual = null;
        try {
            actual = helper.determineOperator(BigDecimal.valueOf(20.317), BigDecimal.valueOf(4.22), "*");
        } catch (Exception e) {
            System.out.println("test failed");
        }
        assertEquals(BigDecimal.valueOf(85.73774), actual);
    }

    @Test
    void testDetermineOperator_Modulo() {
        BigDecimal actual = null;
        try {
            actual = helper.determineOperator(BigDecimal.valueOf(20.5), BigDecimal.valueOf(2.76), "%");
        } catch (Exception e) {
            System.out.println("test failed");
        }
        assertEquals(BigDecimal.valueOf(1.18), actual);
    }

    @Test
    void testDetermineOperator_Exponent() {
        BigDecimal actual = null;
        try {
            actual = helper.determineOperator(BigDecimal.valueOf(20.742), BigDecimal.valueOf(3), "^");
        } catch (Exception e) {
            System.out.println("test failed");
        }
        assertEquals(BigDecimal.valueOf(8923.842358488), actual);
    }

    @Test
    void testDetermineOperator_Divide() {
        BigDecimal actual = null;
        try {
            actual = helper.determineOperator(BigDecimal.valueOf(60.89), BigDecimal.valueOf(13.61), "/");
        } catch (Exception e) {
            System.out.println("test failed");
        }
        assertEquals(BigDecimal.valueOf(4.47), actual);
    }

}
