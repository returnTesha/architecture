package com.returntesha.arch_comparison.domain.diag.hexagonal.infrastructure.persistence.adapter;

import com.returntesha.arch_comparison.domain.diag.hexagonal.application.port.output.StudentRepository;
import com.returntesha.arch_comparison.domain.diag.hexagonal.domain.Student;
import com.returntesha.arch_comparison.domain.diag.hexagonal.domain.StudentId;
import com.returntesha.arch_comparison.domain.diag.hexagonal.infrastructure.persistence.entity.StudentJpaEntity;
import com.returntesha.arch_comparison.domain.diag.hexagonal.infrastructure.persistence.mapper.StudentMapper;
import com.returntesha.arch_comparison.domain.diag.hexagonal.infrastructure.persistence.repository.StudentJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Secondary Adapter - Repository 포트 구현체
 * ✅ [장점] 도메인의 StudentRepository 포트를 JPA로 구현
 * ✅ [장점] 도메인은 JPA에 대해 모르고, 순수한 비즈니스 로직에만 집중
 * ✅ [장점] 나중에 MongoDB, Redis 등으로 쉽게 교체 가능
 * ✅ [장점] 매핑 로직을 통해 도메인과 인프라의 완전한 분리
 */
@Repository
public class StudentRepositoryAdapter implements StudentRepository {

    private final StudentJpaRepository jpaRepository;

    public StudentRepositoryAdapter(StudentJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Student> findById(StudentId studentId) {
        Optional<StudentJpaEntity> entityOpt = jpaRepository.findById(studentId.getValue());
        return entityOpt.map(StudentMapper::toDomain);
    }

    @Override
    public Student normalSave(Student student) {
        // 새로운 학생인 경우
        if (student.getId().getValue() == null) {
            StudentJpaEntity newEntity = StudentMapper.toEntity(student);
            StudentJpaEntity savedEntity = jpaRepository.save(newEntity);
            return StudentMapper.toDomain(savedEntity);
        }

        // 기존 학생 업데이트인 경우
        StudentJpaEntity existingEntity = jpaRepository.findById(student.getId().getValue())
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 학생입니다: " + student.getId()));

        StudentMapper.updateEntity(existingEntity, student);
        StudentJpaEntity savedEntity = jpaRepository.save(existingEntity);
        return StudentMapper.toDomain(savedEntity);
    }
}
