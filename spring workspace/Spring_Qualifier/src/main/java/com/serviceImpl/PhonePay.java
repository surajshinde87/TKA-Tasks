package com.serviceImpl;

import org.springframework.stereotype.Component;

import com.service.Payment;

@Component("phonePay")
public class PhonePay implements Payment{

	@Override
	public String makePayment() {
		return "Making Payment using Phonepay";
	}

}
