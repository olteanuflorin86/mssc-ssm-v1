package com.olteanuflorin86.msscssmv1.services;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.transaction.annotation.Transactional;

import com.olteanuflorin86.msscssmv1.domain.Payment;
import com.olteanuflorin86.msscssmv1.domain.PaymentEvent;
import com.olteanuflorin86.msscssmv1.domain.PaymentState;
import com.olteanuflorin86.msscssmv1.repository.PaymentRepository;

@SpringBootTest
public class PaymentServiceImplTest {
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	PaymentRepository paymentRepository;
	
	Payment payment;

	@BeforeEach
	void setUp() {
		payment = Payment.builder().amount(new BigDecimal("12.99")).build();
	}
	
	@Transactional
	@Test
	void preAuth() {
		Payment savedPayment = paymentService.newPayment(payment);
		
		System.out.println("Should be NEW");
        System.out.println(savedPayment.getState()); 
        
        paymentService.preAuth(savedPayment.getId());
        
        StateMachine<PaymentState, PaymentEvent> sm = paymentService.preAuth(savedPayment.getId());

        Payment preAuthedPayment = paymentRepository.getOne(savedPayment.getId());

        System.out.println("Should be PRE_AUTH");
        System.out.println(sm.getState().getId());

        System.out.println(preAuthedPayment);
	}

}
