package com.returntesha.arch_comparison.domain.diag.layered.repository;

import com.returntesha.arch_comparison.domain.diag.layered.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface LayeredRepository extends JpaRepository<StudentEntity, Long> {
    // 아무것도 안 적어도 findById, save, findAll 다 됨.
}
