package com.returntesha.arch_comparison.domain.diag.hexagonal.infrastructure.persistence.mapper;

import com.returntesha.arch_comparison.domain.diag.hexagonal.domain.Grade;
import com.returntesha.arch_comparison.domain.diag.hexagonal.domain.ProfessorEmail;
import com.returntesha.arch_comparison.domain.diag.hexagonal.domain.Student;
import com.returntesha.arch_comparison.domain.diag.hexagonal.domain.StudentId;
import com.returntesha.arch_comparison.domain.diag.hexagonal.infrastructure.persistence.entity.StudentJpaEntity;

/**
 * 도메인 모델 ↔ JPA 엔티티 매핑 유틸리티
 * ✅ [장점] 도메인과 인프라스트럭처 계층 간의 변환 로직 분리
 * ✅ [장점] 각 계층이 자신의 모델을 독립적으로 발전시킬 수 있음
 * ✅ [장점] 변환 로직의 중앙 집중화
 */
public class StudentMapper {

    /**
     * JPA 엔티티 → 도메인 모델 변환
     */
    public static Student toDomain(StudentJpaEntity entity) {
        if (entity == null) {
            return null;
        }

        return new Student(
            new StudentId(entity.getId()),
            entity.getName(),
            new Grade(entity.getGrade()),
            new ProfessorEmail(entity.getProfessorEmail())
        );
    }

    /**
     * 도메인 모델 → JPA 엔티티 변환
     */
    public static StudentJpaEntity toEntity(Student student) {
        if (student == null) {
            return null;
        }

        return new StudentJpaEntity(
            student.getId().getValue(),
            student.getName(),
            student.getGrade().getValue(),
            student.getProfessorEmail().getValue()
        );
    }

    /**
     * 기존 JPA 엔티티 업데이트 (ID 유지)
     */
    public static void updateEntity(StudentJpaEntity entity, Student student) {
        if (entity == null || student == null) {
            throw new IllegalArgumentException("Entity와 Student 모두 null이 아니어야 합니다.");
        }

        entity.setName(student.getName());
        entity.setGrade(student.getGrade().getValue());
        entity.setProfessorEmail(student.getProfessorEmail().getValue());
    }
}
