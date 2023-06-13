package com.olteanuflorin86.msscssmv1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.olteanuflorin86.msscssmv1.domain.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
