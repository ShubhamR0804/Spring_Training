package com.techlabs.employeedboperations.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment {
	@Column(name="paymentId")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int paymentId;
	@Column(name="paymentDate")
	private LocalDate paymentDate;
	@Column(name="amount")
	private BigDecimal amount;
	@Enumerated(EnumType.STRING)
	@Column(name="paymentMode")
	private PaymentMode paymentMode;
	@Enumerated(EnumType.STRING)
	@Column(name="paymentStatus")
	private PaymentStatus paymentStatus;
	public Payment(LocalDate paymentDate, BigDecimal amount, PaymentMode paymentMode, PaymentStatus paymentStatus) {
		super();
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.paymentMode = paymentMode;
		this.paymentStatus = paymentStatus;
	}
	public Payment() {
		super();
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	

}
