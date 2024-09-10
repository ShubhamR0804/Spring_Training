package com.techlabs.validationandexception.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.techlabs.validationandexception.dto.PageResponseDto;
import com.techlabs.validationandexception.entity.Payment;
import com.techlabs.validationandexception.exception.PaymentNotFoundException;
import com.techlabs.validationandexception.repository.PaymentRepository;

import jakarta.transaction.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public PageResponseDto<Payment> getAllPayments(int pageNumber, int pageSize) {
		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Payment> paymentPage = paymentRepository.findAll(pageable);

		PageResponseDto<Payment> paymentPageDto = new PageResponseDto<>();
		paymentPageDto.setTotalElements((int) paymentPage.getTotalElements());
		paymentPageDto.setTotalPages(paymentPage.getTotalPages());
		paymentPageDto.setSize(paymentPage.getSize());
		paymentPageDto.setContent(paymentPage.getContent());
		paymentPageDto.setLastPage(paymentPage.isLast());
		return paymentPageDto;
	}

	@Override
	public Payment getPaymentById(int paymentId) {
		// TODO Auto-generated method stub
		Payment payment = paymentRepository.findById(paymentId).orElse(null);
		if (payment == null) {
			throw new PaymentNotFoundException();
		}
		return payment;
	}

	@Override
	@Transactional
	public Payment insertPayment(Payment payment) {
		// TODO Auto-generated method stub
		return paymentRepository.save(payment);
	}

	@Override
	@Transactional
	public Payment updatePayment(Payment payment) {
		// TODO Auto-generated method stub
		boolean exists = paymentRepository.existsById(payment.getPaymentid());
		if (!exists) {
			throw new PaymentNotFoundException();
		}
		return paymentRepository.save(payment);
	}

}
