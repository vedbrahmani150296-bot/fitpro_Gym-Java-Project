package com.fitpro.gym.repository;

import com.fitpro.gym.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByDate(LocalDate date);
    List<Attendance> findByMemberId(Long memberId);
    List<Attendance> findByMemberIdAndDateBetween(Long memberId, LocalDate start, LocalDate end);
    Optional<Attendance> findByMemberIdAndDate(Long memberId, LocalDate date);
    long countByDateAndStatus(LocalDate date, String status);
}
