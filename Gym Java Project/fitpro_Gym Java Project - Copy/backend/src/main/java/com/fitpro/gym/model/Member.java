package com.fitpro.gym.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;

    @Column(nullable = false)
    private String phone;

    private LocalDate dob;

    private String address;

    @Column(name = "join_date")
    private LocalDate joinDate;

    @Column(nullable = false)
    private String status = "Active";

    @Column(name = "plan_id")
    private Long planId;

    @Column(name = "trainer_id")
    private Long trainerId;

    // ── Constructors ─────────────────
    public Member() {}

    // ── Getters & Setters ────────────
    public Long getId()                  { return id; }
    public void setId(Long id)           { this.id = id; }

    public String getName()              { return name; }
    public void setName(String name)     { this.name = name; }

    public String getEmail()             { return email; }
    public void setEmail(String email)   { this.email = email; }

    public String getPhone()             { return phone; }
    public void setPhone(String phone)   { this.phone = phone; }

    public LocalDate getDob()            { return dob; }
    public void setDob(LocalDate dob)    { this.dob = dob; }

    public String getAddress()               { return address; }
    public void setAddress(String address)   { this.address = address; }

    public LocalDate getJoinDate()               { return joinDate; }
    public void setJoinDate(LocalDate joinDate)  { this.joinDate = joinDate; }

    public String getStatus()                { return status; }
    public void setStatus(String status)     { this.status = status; }

    public Long getPlanId()              { return planId; }
    public void setPlanId(Long planId)   { this.planId = planId; }

    public Long getTrainerId()                   { return trainerId; }
    public void setTrainerId(Long trainerId)     { this.trainerId = trainerId; }
}
