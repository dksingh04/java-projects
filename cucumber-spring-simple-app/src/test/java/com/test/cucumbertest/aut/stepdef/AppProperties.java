package com.test.cucumbertest.aut.stepdef;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.test.context.TestPropertySource;

@Component
@Configuration
@TestPropertySource("classpath:test.properties")
public class AppProperties {
	@Value("${key1}")
	private String key1;

	public String getKey1() {
		return key1;
	}

	public void setKey1(String key1) {
		
		this.key1 = key1;
	}
	
}
