package com.example.demoapi.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorServiceHelperTest {

    private CalculatorServiceHelper helper;

    @BeforeEach
    void setUp() {
        helper = new CalculatorServiceHelper();
    }

    @Test
    @DisplayName("Simple addition should work")
    void testAddNumbers() {

        double actual = helper.addNumbers(6.8, 14.54);

        assertEquals(21.34, actual, "Regular addition should work");
    }

    @Test
    void testDivideNumbers() {

    }

    @Test
    void testExponentNumbers() {

    }

    @Test
    void testMultipyNumbers() {

    }

    @Test
    void testRemainderNumbers() {

    }

    @Test
    void testSubtractNumbers() {

    }
}
