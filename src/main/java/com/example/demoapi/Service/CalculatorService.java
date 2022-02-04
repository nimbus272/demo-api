package com.example.demoapi.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fathzer.soft.javaluator.DoubleEvaluator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorService {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CalculatorService.class);

    public CalculatorService() {
    }

    public Double runCalculator(ObjectNode objectNode) throws NullPointerException {
        LOGGER.info("Reached runCalculator with expression recieved: {}",
                objectNode.get("expression").asText());
        String expression = objectNode.get("expression").asText();
        String newExpression = evaluateString(expression);
        
        LOGGER.info("Removed parentheses from expression, new expression is : {}", newExpression);

        DoubleEvaluator eval = new DoubleEvaluator();
        try {
            return eval.evaluate(newExpression);
        } catch (IllegalArgumentException e) {
            LOGGER.error(e.getMessage());
            throw new NullPointerException();
        }

    }

    public String evaluateString(String expression) {
        DoubleEvaluator eval = new DoubleEvaluator();
        int lParen = -1;
        int rParen = -1;
        String subExpression = "";
        String newExpression = expression;
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                lParen = i;
            } else if (expression.charAt(i) == ')'  && lParen >= 0) {
                rParen = i;
            }
            if (lParen >= 0 && rParen >= 0) {
                subExpression = expression.substring(lParen, rParen + 1);
                
                double solution = 0;
                try {
                    solution = eval.evaluate(subExpression);
                    rParen = -1;
                    lParen = -1;
                } catch (Exception e) {
                    LOGGER.error(e.getMessage());
                }


                newExpression = newExpression.replace(subExpression, String.valueOf(solution));

                
            }
        }
        if (newExpression.contains("(") || newExpression.contains(")")) {
            newExpression = evaluateString(newExpression);
        }


        return newExpression;
    }
}
