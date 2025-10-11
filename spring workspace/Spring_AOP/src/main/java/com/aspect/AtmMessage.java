package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AtmMessage {
	
//	@Before("execution (* com.entity.ATM.*(..))")
//	public void beforeMessage() {
//		System.out.println("Please Enter Your Pin Carefully");
//	}
	
//	@After("execution (* com.entity.ATM.*(..))")
//	public void afterMessage() {
//		System.out.println("Withdrawl Succesfull!");
//	}
	
	@Around("execution (* com.entity.ATM.*(..))")
	public void aroundATM(ProceedingJoinPoint p) {
		
		System.out.println("Welcome to SBI ATM");
		try {
			p.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println("Withdrawl Successful Visit Again");
	}

}
