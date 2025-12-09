package com.returntesha.arch_comparison.domain.diag.hexagonal.application.port.output;

import com.returntesha.arch_comparison.domain.diag.hexagonal.domain.Student;
import com.returntesha.arch_comparison.domain.diag.hexagonal.domain.StudentId;

import java.util.Optional;

/**
 * 출력 포트 (Secondary Port) - 저장소 인터페이스
 * ✅ [장점] 도메인이 인프라스트럭처에 의존하지 않고, 추상화에 의존
 * ✅ [장점] JPA, MyBatis, MongoDB 등으로 자유롭게 구현 변경 가능
 * ✅ [장점] 테스트 시 Mock으로 쉽게 대체 가능
 */
public interface StudentRepository {

    /**
     * 학생 조회
     * @param studentId 학생 ID
     * @return 학생 객체 (없으면 Empty)
     */
    Optional<Student> findById(StudentId studentId);

    /**
     * 학생 저장
     * @param student 저장할 학생
     * @return 저장된 학생
     */
    Student normalSave(Student student);
}
