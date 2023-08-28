package com.example.demo;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.example.demo.stepdefs"
		)
public class TestClass {
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

}
