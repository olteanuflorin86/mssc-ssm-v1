package com.olteanuflorin86.msscssmv1.config.guards;

import org.springframework.statemachine.StateContext; 
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

import com.olteanuflorin86.msscssmv1.domain.PaymentEvent;
import com.olteanuflorin86.msscssmv1.domain.PaymentState;
import com.olteanuflorin86.msscssmv1.services.PaymentServiceImpl;

@Component
public class PaymentIdGuard implements Guard<PaymentState, PaymentEvent> {

    @Override
    public boolean evaluate(StateContext<PaymentState, PaymentEvent> context) {
        return context.getMessageHeader(PaymentServiceImpl.PAYMENT_ID_HEADER) != null;
    }
}
