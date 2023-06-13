package com.olteanuflorin86.msscssmv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.olteanuflorin86.msscssmv1.domain.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
