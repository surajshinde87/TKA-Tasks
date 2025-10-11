package com.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.service.Payment;

@Component
public class User {
	
	@Autowired
	@Qualifier("upi")
	Payment upiPayment;
	
	
	@Autowired
	@Qualifier("phonePay")
	Payment phonePayment;

	public Payment getUpiPayment() {
		return upiPayment;
	}

	public void setUpiPayment(Payment upiPayment) {
		this.upiPayment = upiPayment;
	}

	public Payment getPhonePayment() {
		return phonePayment;
	}

	public void setPhonePayment(Payment phonePayment) {
		this.phonePayment = phonePayment;
	}
	
	
	

}
