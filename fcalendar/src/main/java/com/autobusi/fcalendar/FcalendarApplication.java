package com.autobusi.fcalendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class FcalendarApplication {
	private static final Logger log = LoggerFactory.getLogger(FcalendarApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FcalendarApplication.class, args);
	}
}
