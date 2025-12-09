package com.returntesha.arch_comparison.domain.diag.hexagonal.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * JPA 엔티티 (인프라스트럭처 계층)
 * ✅ [장점] 도메인 모델과 분리되어 기술적 관심사만 담당
 * ✅ [장점] JPA 어노테이션이 도메인 모델을 오염시키지 않음
 * ✅ [장점] 도메인 모델의 변경이 DB 스키마에 직접 영향을 주지 않음
 */
@Entity
@Table(name = "hexagonal_student")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer grade;

    @Column(name = "professor_email", nullable = false)
    private String professorEmail;

    public StudentJpaEntity(Long id, String name, Integer grade, String professorEmail) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.professorEmail = professorEmail;
    }
}
