package com.returntesha.arch_comparison.domain.diag.hexagonal.infrastructure.persistence.repository;

import com.returntesha.arch_comparison.domain.diag.hexagonal.infrastructure.persistence.entity.StudentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA Repository 인터페이스 (인프라스트럭처 계층)
 * ✅ [장점] Spring Data JPA의 기술적 세부사항을 캡슐화
 * ✅ [장점] 도메인 계층에서는 이 인터페이스를 직접 알지 못함
 */
public interface StudentJpaRepository extends JpaRepository<StudentJpaEntity, Long> {
}
