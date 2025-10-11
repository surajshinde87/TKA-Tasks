package com.serviceImpl;

import org.springframework.stereotype.Component;

import com.service.Payment;

@Component("upi")
public class UPI implements Payment {

	@Override
	public String makePayment() {
		return "Making Payment using UPI";
	}

}
