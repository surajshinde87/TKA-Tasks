package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.config.ConfigClass;
import com.entities.Employee;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
		Employee e = context.getBean(Employee.class);
		
		System.out.println(e);

	}

}
