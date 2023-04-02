package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	private final Logger LOGGER = LoggerFactory.getLogger(WelcomeController.class);

	@GetMapping("/hello")
	public String sayWelcome(@RequestHeader(name = "userId") String userId) throws InterruptedException {
		MDC.put("userId", userId);
		var startTime = System.currentTimeMillis();
		LOGGER.info("WelcomeController::sayWelcome-Info");

		String msg = "Hi, Welcome back";
		Thread.sleep(1000);
		var endTime = System.currentTimeMillis();
		MDC.put("processTime", ((endTime-startTime)/1000)+"");
		LOGGER.info("WelcomeController::complete");

		return msg;
	}
}
