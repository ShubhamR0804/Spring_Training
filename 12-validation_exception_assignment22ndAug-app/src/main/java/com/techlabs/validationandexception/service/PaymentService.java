package com.techlabs.validationandexception.service;

import com.techlabs.validationandexception.dto.PageResponseDto;
import com.techlabs.validationandexception.entity.Payment;

public interface PaymentService {
	
	PageResponseDto<Payment> getAllPayments(int pageNumber, int pageSize);

	Payment getPaymentById(int paymentId);

	Payment insertPayment(Payment payment);

	Payment updatePayment(Payment payment);

}
