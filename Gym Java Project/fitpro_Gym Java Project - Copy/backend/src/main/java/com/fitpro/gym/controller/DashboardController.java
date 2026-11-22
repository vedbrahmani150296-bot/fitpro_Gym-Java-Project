package com.fitpro.gym.controller;

import com.fitpro.gym.dto.DashboardStats;
import com.fitpro.gym.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired private MemberRepository    memberRepo;
    @Autowired private TrainerRepository   trainerRepo;
    @Autowired private MembershipPlanRepository planRepo;
    @Autowired private PaymentRepository   paymentRepo;
    @Autowired private AttendanceRepository attendanceRepo;

    /** GET /api/dashboard/stats — KPI summary for the dashboard */
    @GetMapping("/stats")
    public DashboardStats getStats() {
        LocalDate firstOfMonth = LocalDate.now().withDayOfMonth(1);

        return DashboardStats.builder()
            .totalMembers  (memberRepo.count())
            .activeMembers (memberRepo.findByStatus("Active").size())
            .inactiveMembers(memberRepo.findByStatus("Inactive").size())
            .expiredMembers(memberRepo.findByStatus("Expired").size())
            .totalRevenue  (paymentRepo.getTotalRevenue())
            .monthRevenue  (paymentRepo.getRevenueFrom(firstOfMonth))
            .todayAttendance(attendanceRepo.countByDateAndStatus(LocalDate.now(), "Present"))
            .totalTrainers (trainerRepo.count())
            .totalPlans    (planRepo.count())
            .totalPayments (paymentRepo.count())
            .build();
    }

    /** GET /api/dashboard/monthly-revenue — last 6 months revenue */
    @GetMapping("/monthly-revenue")
    public List<Map<String, Object>> getMonthlyRevenue() {
        List<Map<String, Object>> result = new ArrayList<>();
        for (int i = 5; i >= 0; i--) {
            LocalDate d = LocalDate.now().minusMonths(i);
            LocalDate start = d.withDayOfMonth(1);
            LocalDate end   = d.withDayOfMonth(d.lengthOfMonth());
            long rev = paymentRepo.findByDateBetween(start, end)
                                  .stream().mapToLong(p -> p.getAmount()).sum();
            result.add(Map.of(
                "month", d.getMonth().name().substring(0,3),
                "revenue", rev
            ));
        }
        return result;
    }
}
