package com.fitpro.gym.controller;

import com.fitpro.gym.model.Member;
import com.fitpro.gym.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberRepository memberRepo;

    /** GET /api/members — get all members */
    @GetMapping
    public List<Member> getAll() {
        return memberRepo.findAll();
    }

    /** GET /api/members/{id} — get single member */
    @GetMapping("/{id}")
    public ResponseEntity<Member> getById(@PathVariable Long id) {
        return memberRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /** POST /api/members — add new member */
    @PostMapping
    public Member create(@RequestBody Member member) {
        if (member.getJoinDate() == null) {
            member.setJoinDate(LocalDate.now());
        }
        return memberRepo.save(member);
    }

    /** PUT /api/members/{id} — update member */
    @PutMapping("/{id}")
    public ResponseEntity<Member> update(@PathVariable Long id, @RequestBody Member updated) {
        return memberRepo.findById(id).map(member -> {
            member.setName(updated.getName());
            member.setEmail(updated.getEmail());
            member.setPhone(updated.getPhone());
            member.setDob(updated.getDob());
            member.setAddress(updated.getAddress());
            if (updated.getJoinDate() != null) {
                member.setJoinDate(updated.getJoinDate());
            }
            member.setStatus(updated.getStatus());
            member.setPlanId(updated.getPlanId());
            member.setTrainerId(updated.getTrainerId());
            return ResponseEntity.ok(memberRepo.save(member));
        }).orElse(ResponseEntity.notFound().build());
    }

    /** DELETE /api/members/{id} — delete member */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!memberRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        memberRepo.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
