package com.fitpro.gym.controller;

import com.fitpro.gym.dto.AttendanceRequest;
import com.fitpro.gym.model.Attendance;
import com.fitpro.gym.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepo;

    /** GET /api/attendance — get all records */
    @GetMapping
    public List<Attendance> getAll() {
        return attendanceRepo.findAll();
    }

    /** GET /api/attendance/date?date=2024-06-01 */
    @GetMapping("/date")
    public List<Attendance> getByDate(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return attendanceRepo.findByDate(date);
    }

    /** GET /api/attendance/member/{memberId} */
    @GetMapping("/member/{memberId}")
    public List<Attendance> getByMember(@PathVariable Long memberId) {
        return attendanceRepo.findByMemberId(memberId);
    }

    /**
     * POST /api/attendance/mark
     * Marks or updates attendance for a member on a given date.
     * Body: { "memberId": 1, "date": "2024-06-01", "status": "Present" }
     */
    @PostMapping("/mark")
    public Attendance mark(@RequestBody AttendanceRequest request) {
        LocalDate date = request.getDate() != null ? request.getDate() : LocalDate.now();

        // Update existing record or create new one
        Attendance record = attendanceRepo
                .findByMemberIdAndDate(request.getMemberId(), date)
                .orElse(new Attendance());

        record.setMemberId(request.getMemberId());
        record.setDate(date);
        record.setStatus(request.getStatus());

        return attendanceRepo.save(record);
    }

    /** DELETE /api/attendance/{id} */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!attendanceRepo.existsById(id)) return ResponseEntity.notFound().build();
        attendanceRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
