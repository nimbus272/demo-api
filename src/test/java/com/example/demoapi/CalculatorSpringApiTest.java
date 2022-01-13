package com.example.demoapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.example.demoapi.controller.CalculatorServiceRest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculatorSpringApiTest {

	@Autowired
	private CalculatorServiceRest controller;

	@Test
	void contextLoads() throws Exception {
		assertNotNull(controller);
	}

}
