package com.olteanuflorin86.msscssmv1.services;

import org.springframework.statemachine.StateMachine;

import com.olteanuflorin86.msscssmv1.domain.Payment;
import com.olteanuflorin86.msscssmv1.domain.PaymentEvent;
import com.olteanuflorin86.msscssmv1.domain.PaymentState;

public interface PaymentService {

	Payment newPayment(Payment payment);

    StateMachine<PaymentState, PaymentEvent> preAuth(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> authorizePayment(Long paymentId);

    StateMachine<PaymentState, PaymentEvent> declineAuth(Long paymentId);
    
}
