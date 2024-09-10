package com.techlabs.validationandexception.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.techlabs.validationandexception.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	Page<Payment> findAll(Pageable pageable);
}
