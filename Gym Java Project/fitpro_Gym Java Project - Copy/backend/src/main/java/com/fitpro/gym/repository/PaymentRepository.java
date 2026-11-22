package com.fitpro.gym.repository;

import com.fitpro.gym.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByMemberId(Long memberId);
    List<Payment> findByPlanId(Long planId);
    List<Payment> findByDateBetween(LocalDate start, LocalDate end);

    @Query("SELECT COALESCE(SUM(p.amount), 0) FROM Payment p")
    Long getTotalRevenue();

    @Query("SELECT COALESCE(SUM(p.amount), 0) FROM Payment p WHERE p.date >= :start")
    Long getRevenueFrom(LocalDate start);
}
