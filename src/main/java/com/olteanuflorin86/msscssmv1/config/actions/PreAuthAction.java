package com.olteanuflorin86.msscssmv1.config.actions;

import java.util.Random; 

import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

import com.olteanuflorin86.msscssmv1.domain.PaymentEvent;
import com.olteanuflorin86.msscssmv1.domain.PaymentState;
import com.olteanuflorin86.msscssmv1.services.PaymentServiceImpl;

@Component
public class PreAuthAction implements Action<PaymentState, PaymentEvent>{

    @Override
    public void execute(StateContext<PaymentState, PaymentEvent> context) {
        System.out.println("PreAuth was called!!!");

        if (new Random().nextInt(10) < 8) {
            System.out.println("Pre Auth Approved");
            context.getStateMachine().sendEvent(MessageBuilder.withPayload(PaymentEvent.PRE_AUTH_APPROVED)
                    .setHeader(PaymentServiceImpl.PAYMENT_ID_HEADER, context.getMessageHeader(PaymentServiceImpl.PAYMENT_ID_HEADER))
                    .build());

        } else {
            System.out.println("Per Auth Declined! No Credit!!!!!!");
            context.getStateMachine().sendEvent(MessageBuilder.withPayload(PaymentEvent.PRE_AUTH_DECLINED)
                    .setHeader(PaymentServiceImpl.PAYMENT_ID_HEADER, context.getMessageHeader(PaymentServiceImpl.PAYMENT_ID_HEADER))
                    .build());
        }
    }
}