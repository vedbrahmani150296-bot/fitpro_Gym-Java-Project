package com.fitpro.gym.controller;

import com.fitpro.gym.model.Trainer;
import com.fitpro.gym.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")
public class TrainerController {

    @Autowired
    private TrainerRepository trainerRepo;

    /** GET /api/trainers */
    @GetMapping
    public List<Trainer> getAll() {
        return trainerRepo.findAll();
    }

    /** GET /api/trainers/{id} */
    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getById(@PathVariable Long id) {
        return trainerRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /** POST /api/trainers */
    @PostMapping
    public Trainer create(@RequestBody Trainer trainer) {
        return trainerRepo.save(trainer);
    }

    /** PUT /api/trainers/{id} */
    @PutMapping("/{id}")
    public ResponseEntity<Trainer> update(@PathVariable Long id, @RequestBody Trainer updated) {
        return trainerRepo.findById(id).map(t -> {
            t.setName(updated.getName());
            t.setEmail(updated.getEmail());
            t.setPhone(updated.getPhone());
            t.setSpecialization(updated.getSpecialization());
            t.setExperience(updated.getExperience());
            t.setSalary(updated.getSalary());
            t.setStatus(updated.getStatus());
            return ResponseEntity.ok(trainerRepo.save(t));
        }).orElse(ResponseEntity.notFound().build());
    }

    /** DELETE /api/trainers/{id} */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!trainerRepo.existsById(id)) return ResponseEntity.notFound().build();
        trainerRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
