package com.techlabs.validationandexception.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "payments")
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {

	@Column(name="paymentid")
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentid;

    @Column
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Payment date cannot be null")
    private Date paymentdate;

    @Column
    private double amount;

    @Enumerated(EnumType.STRING)
    @Column
    @NotNull(message = "Payment mode cannot be null")
    private PaymentMode paymentmode;

    @Enumerated(EnumType.STRING)
    @Column
    @NotNull(message = "Payment status cannot be null")
    private PaymentStatus paymentstatus;
}
