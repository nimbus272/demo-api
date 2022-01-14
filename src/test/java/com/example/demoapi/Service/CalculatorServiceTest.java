package com.example.demoapi.Service;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import com.fathzer.soft.javaluator.DoubleEvaluator;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorServiceTest {

    DoubleEvaluator eval;

    CalculatorService service;
    ObjectNode node;

    @BeforeEach
    void setUp() {
        service = new CalculatorService();
        eval = new DoubleEvaluator();
    }

    @Test
    void testRunCalculator() {
        node = new ObjectNode(JsonNodeFactory.instance);

        String expression = "12 + 4 * (5 / 2^3)";
        node.put("expression", expression);

        assertNotNull(service.runCalculator(node));
    }
}
