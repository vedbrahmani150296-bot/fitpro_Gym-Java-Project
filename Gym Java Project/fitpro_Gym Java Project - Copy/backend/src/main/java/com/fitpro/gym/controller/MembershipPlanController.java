package com.fitpro.gym.controller;

import com.fitpro.gym.model.MembershipPlan;
import com.fitpro.gym.repository.MembershipPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plans")
public class MembershipPlanController {

    @Autowired
    private MembershipPlanRepository planRepo;

    /** GET /api/plans */
    @GetMapping
    public List<MembershipPlan> getAll() {
        return planRepo.findAll();
    }

    /** GET /api/plans/{id} */
    @GetMapping("/{id}")
    public ResponseEntity<MembershipPlan> getById(@PathVariable Long id) {
        return planRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /** POST /api/plans */
    @PostMapping
    public MembershipPlan create(@RequestBody MembershipPlan plan) {
        return planRepo.save(plan);
    }

    /** PUT /api/plans/{id} */
    @PutMapping("/{id}")
    public ResponseEntity<MembershipPlan> update(@PathVariable Long id, @RequestBody MembershipPlan updated) {
        return planRepo.findById(id).map(p -> {
            p.setName(updated.getName());
            p.setPrice(updated.getPrice());
            p.setDuration(updated.getDuration());
            p.setDescription(updated.getDescription());
            p.setFeatures(updated.getFeatures());
            return ResponseEntity.ok(planRepo.save(p));
        }).orElse(ResponseEntity.notFound().build());
    }

    /** DELETE /api/plans/{id} */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!planRepo.existsById(id)) return ResponseEntity.notFound().build();
        planRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
