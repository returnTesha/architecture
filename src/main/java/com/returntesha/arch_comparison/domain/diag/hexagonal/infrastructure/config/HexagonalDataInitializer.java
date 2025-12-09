package com.returntesha.arch_comparison.domain.diag.hexagonal.infrastructure.config;

import com.returntesha.arch_comparison.domain.diag.hexagonal.infrastructure.persistence.entity.StudentJpaEntity;
import com.returntesha.arch_comparison.domain.diag.hexagonal.infrastructure.persistence.repository.StudentJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 헥사고날 아키텍처 테스트 데이터 초기화
 * ✅ [장점] 인프라스트럭처 계층에서만 기술적 초기화 담당
 * ✅ [장점] 도메인 계층은 이러한 초기화 로직을 알 필요 없음
 */
@Component
@Order(2) // layered 다음에 실행
public class HexagonalDataInitializer implements CommandLineRunner {

    private final StudentJpaRepository studentJpaRepository;

    public HexagonalDataInitializer(StudentJpaRepository studentJpaRepository) {
        this.studentJpaRepository = studentJpaRepository;
    }

    @Override
    public void run(String... args) {
        // 헥사고날 아키텍처 테스트용 학생 데이터
        if (studentJpaRepository.count() == 0) {
            StudentJpaEntity student1 = new StudentJpaEntity(null, "홍길동", 1, "prof@univ.ac.kr");
            StudentJpaEntity student2 = new StudentJpaEntity(null, "한둘리", 2, "prof@univ.ac.kr");
            StudentJpaEntity student3 = new StudentJpaEntity(null, "김철수", 3, "prof@univ.ac.kr");
            StudentJpaEntity student4 = new StudentJpaEntity(null, "이영희", 4, "prof@univ.ac.kr");

            StudentJpaEntity saved1 = studentJpaRepository.save(student1);
            StudentJpaEntity saved2 = studentJpaRepository.save(student2);
            StudentJpaEntity saved3 = studentJpaRepository.save(student3);
            StudentJpaEntity saved4 = studentJpaRepository.save(student4);

            System.out.println("🏗️ [Hexagonal] 테스트 데이터가 초기화되었습니다.");
            System.out.println("   - " + saved1.getId() + ": 홍길동 (1학년) - 진단 신청 불가");
            System.out.println("   - " + saved2.getId() + ": 한둘리 (2학년) - 진단 신청 불가");
            System.out.println("   - " + saved3.getId() + ": 김철수 (3학년) - 진단 신청 불가");
            System.out.println("   - " + saved3.getId() + ": 이영희 (4학년) - 진단 신청 가능");
        }
    }
}
