package com.fitpro.gym.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "attendance",
       uniqueConstraints = @UniqueConstraint(columnNames = {"member_id", "date"}))
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String status;   // Present / Absent

    // ── Constructors ─────────────────
    public Attendance() {}

    // ── Getters & Setters ────────────
    public Long getId()                  { return id; }
    public void setId(Long id)           { this.id = id; }

    public Long getMemberId()                    { return memberId; }
    public void setMemberId(Long memberId)       { this.memberId = memberId; }

    public LocalDate getDate()               { return date; }
    public void setDate(LocalDate date)      { this.date = date; }

    public String getStatus()                { return status; }
    public void setStatus(String status)     { this.status = status; }
}
