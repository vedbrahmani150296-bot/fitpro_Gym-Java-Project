package com.fitpro.gym.controller;

import com.fitpro.gym.model.Payment;
import com.fitpro.gym.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepo;

    /** GET /api/payments */
    @GetMapping
    public List<Payment> getAll() {
        return paymentRepo.findAll();
    }

    /** GET /api/payments/member/{memberId} */
    @GetMapping("/member/{memberId}")
    public List<Payment> getByMember(@PathVariable Long memberId) {
        return paymentRepo.findByMemberId(memberId);
    }

    /** POST /api/payments — record a new payment */
    @PostMapping
    public Payment create(@RequestBody Payment payment) {
        if (payment.getDate() == null) {
            payment.setDate(LocalDate.now());
        }
        return paymentRepo.save(payment);
    }

    /** DELETE /api/payments/{id} */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!paymentRepo.existsById(id)) return ResponseEntity.notFound().build();
        paymentRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
