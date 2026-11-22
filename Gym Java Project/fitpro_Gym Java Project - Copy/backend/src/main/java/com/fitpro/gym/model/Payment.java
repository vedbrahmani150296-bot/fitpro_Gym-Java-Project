package com.fitpro.gym.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "member_id", nullable = false)
    private Long memberId;

    @Column(name = "plan_id")
    private Long planId;

    @Column(nullable = false)
    private Integer amount;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String mode;

    private String notes;

    // ── Constructors ─────────────────
    public Payment() {}

    // ── Getters & Setters ────────────
    public Long getId()                  { return id; }
    public void setId(Long id)           { this.id = id; }

    public Long getMemberId()                    { return memberId; }
    public void setMemberId(Long memberId)       { this.memberId = memberId; }

    public Long getPlanId()              { return planId; }
    public void setPlanId(Long planId)   { this.planId = planId; }

    public Integer getAmount()               { return amount; }
    public void setAmount(Integer amount)    { this.amount = amount; }

    public LocalDate getDate()               { return date; }
    public void setDate(LocalDate date)      { this.date = date; }

    public String getMode()              { return mode; }
    public void setMode(String mode)     { this.mode = mode; }

    public String getNotes()             { return notes; }
    public void setNotes(String notes)   { this.notes = notes; }
}
