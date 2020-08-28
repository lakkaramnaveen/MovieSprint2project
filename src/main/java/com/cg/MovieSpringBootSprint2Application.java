package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//it is a combination of @configuration, @componentscan, @enableautoconfiguration

//it will configure the bean class, starts component scan from base package and auto configures the dispacther servlet 
//tomcat embbeded with ready to serve beans
public class MovieSpringBootSprint2Application {

	public static void main(String[] args) {
		SpringApplication.run(MovieSpringBootSprint2Application.class, args);
		// this will run the application
	}

}
