package com.example.demoapi.Service;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fathzer.soft.javaluator.DoubleEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorService.class);

    public CalculatorService() {
    }

    public Double runCalculator(ObjectNode objectNode) {
        LOGGER.info("Reached runCalculator with expression recieved: {}",
                objectNode.get("expression").asText());
        String expression = objectNode.get("expression").asText();

        DoubleEvaluator eval = new DoubleEvaluator();
        return eval.evaluate(expression);
    }
}
