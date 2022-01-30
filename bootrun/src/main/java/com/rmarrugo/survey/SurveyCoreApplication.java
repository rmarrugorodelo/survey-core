package com.rmarrugo.survey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@EnableAutoConfiguration
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SurveyCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SurveyCoreApplication.class, args);
	}

}
