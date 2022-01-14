package com.example.demoapi.Service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CalculatorServiceTest {

    private static CalculatorService service;
    private static ObjectNode node;

    @Mock
    CalculatorServiceHelper helper;

    @BeforeEach
    void setUp() {
        service = new CalculatorService();
        node = new ObjectNode(JsonNodeFactory.instance);
    }

    @Test
    void testRunCalculator_Addition() {
        node.put("num1", "40.245");
        node.put("num2", "5.72");
        node.put("operator", "+");

        BigDecimal num1 = BigDecimal.valueOf(node.get("num1").doubleValue());
        BigDecimal num2 = BigDecimal.valueOf(node.get("num2").doubleValue());
        String operator = node.get("operator").asText();

        try {
            Mockito.when(helper.determineOperator(num1, num2, operator)).thenReturn(BigDecimal.valueOf(45.965));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertNotNull(service.runCalculator(node));

    }

    @Test
    void testRunCalculator_Subtraction() {
        node.put("num1", "40.245");
        node.put("num2", "5.72");
        node.put("operator", "-");

        BigDecimal num1 = BigDecimal.valueOf(node.get("num1").doubleValue());
        BigDecimal num2 = BigDecimal.valueOf(node.get("num2").doubleValue());
        String operator = node.get("operator").asText();

        try {
            Mockito.when(helper.determineOperator(num1, num2, operator)).thenReturn(BigDecimal.valueOf(34.525));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertNotNull(service.runCalculator(node));
    }

    @Test
    void testRunCalculator_Multiplication() {
        node.put("num1", "40.245");
        node.put("num2", "5.72");
        node.put("operator", "*");

        BigDecimal num1 = BigDecimal.valueOf(node.get("num1").doubleValue());
        BigDecimal num2 = BigDecimal.valueOf(node.get("num2").doubleValue());
        String operator = node.get("operator").asText();

        try {
            Mockito.when(helper.determineOperator(num1, num2, operator)).thenReturn(BigDecimal.valueOf(230.2014));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertNotNull(service.runCalculator(node));
    }

    @Test
    void testRunCalculator_Division() {
        node.put("num1", "40.245");
        node.put("num2", "5.72");
        node.put("operator", "/");

        BigDecimal num1 = BigDecimal.valueOf(node.get("num1").doubleValue());
        BigDecimal num2 = BigDecimal.valueOf(node.get("num2").doubleValue());
        String operator = node.get("operator").asText();

        try {
            Mockito.when(helper.determineOperator(num1, num2, operator)).thenReturn(BigDecimal.valueOf(7.04));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertNotNull(service.runCalculator(node));
    }

    @Test
    void testRunCalculator_Exponent() {
        node.put("num1", "40.245");
        node.put("num2", "5");
        node.put("operator", "^");

        BigDecimal num1 = BigDecimal.valueOf(node.get("num1").doubleValue());
        BigDecimal num2 = BigDecimal.valueOf(node.get("num2").doubleValue());
        String operator = node.get("operator").asText();

        try {
            Mockito.when(helper.determineOperator(num1, num2, operator))
                    .thenReturn(BigDecimal.valueOf(105574652.01948286));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertNotNull(service.runCalculator(node));
    }

    @Test
    void testRunCalculator_Modulus() {
        node.put("num1", "40.245");
        node.put("num2", "5.72");
        node.put("operator", "%");

        BigDecimal num1 = BigDecimal.valueOf(node.get("num1").doubleValue());
        BigDecimal num2 = BigDecimal.valueOf(node.get("num2").doubleValue());
        String operator = node.get("operator").asText();

        try {
            Mockito.when(helper.determineOperator(num1, num2, operator)).thenReturn(BigDecimal.valueOf(0.205));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        assertNotNull(service.runCalculator(node));
    }
}
