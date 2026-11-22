package com.fitpro.gym.repository;

import com.fitpro.gym.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByStatus(String status);
    List<Member> findByPlanId(Long planId);
    List<Member> findByTrainerId(Long trainerId);
}
