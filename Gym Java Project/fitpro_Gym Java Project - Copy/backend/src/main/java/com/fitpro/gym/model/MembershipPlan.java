package com.fitpro.gym.model;

import jakarta.persistence.*;

@Entity
@Table(name = "membership_plan")
public class MembershipPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer duration;

    private String description;

    @Column(columnDefinition = "TEXT")
    private String features;   // comma-separated

    // ── Constructors ─────────────────
    public MembershipPlan() {}

    // ── Getters & Setters ────────────
    public Long getId()                  { return id; }
    public void setId(Long id)           { this.id = id; }

    public String getName()              { return name; }
    public void setName(String name)     { this.name = name; }

    public Integer getPrice()                { return price; }
    public void setPrice(Integer price)      { this.price = price; }

    public Integer getDuration()                 { return duration; }
    public void setDuration(Integer duration)    { this.duration = duration; }

    public String getDescription()                       { return description; }
    public void setDescription(String description)       { this.description = description; }

    public String getFeatures()                  { return features; }
    public void setFeatures(String features)     { this.features = features; }
}
