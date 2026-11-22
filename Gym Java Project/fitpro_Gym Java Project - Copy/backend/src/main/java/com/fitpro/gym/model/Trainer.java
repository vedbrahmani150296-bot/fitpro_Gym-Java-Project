package com.fitpro.gym.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trainer")
public class Trainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private String email;
    private String phone;
    private String specialization;
    private Integer experience;
    private Integer salary;

    @Column(nullable = false)
    private String status = "Active";

    // ── Constructors ─────────────────
    public Trainer() {}

    // ── Getters & Setters ────────────
    public Long getId()                      { return id; }
    public void setId(Long id)               { this.id = id; }

    public String getName()                  { return name; }
    public void setName(String name)         { this.name = name; }

    public String getEmail()                 { return email; }
    public void setEmail(String email)       { this.email = email; }

    public String getPhone()                 { return phone; }
    public void setPhone(String phone)       { this.phone = phone; }

    public String getSpecialization()                        { return specialization; }
    public void setSpecialization(String specialization)     { this.specialization = specialization; }

    public Integer getExperience()                   { return experience; }
    public void setExperience(Integer experience)    { this.experience = experience; }

    public Integer getSalary()               { return salary; }
    public void setSalary(Integer salary)    { this.salary = salary; }

    public String getStatus()                { return status; }
    public void setStatus(String status)     { this.status = status; }
}
