package com.olteanuflorin86.msscssmv1.config.actions;

import org.springframework.statemachine.StateContext; 
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import com.olteanuflorin86.msscssmv1.domain.PaymentEvent;
import com.olteanuflorin86.msscssmv1.domain.PaymentState;

@Component
public class AuthApprovedAction implements Action<PaymentState, PaymentEvent> {
    @Override
    public void execute(StateContext<PaymentState, PaymentEvent> context) {
        System.out.println("Sending Notification of Auth APPROVED");
    }
}
