package com.returntesha.arch_comparison.domain.diag.hexagonal.domain;

import java.util.Objects;

/**
 * 학생 ID 값 객체
 * ✅ [장점] 타입 안전성 확보 (Long으로 섞여서 사용되는 것을 방지)
 * ✅ [장점] 의미있는 도메인 언어 사용
 */
public class StudentId {
    private final Long value;

    public StudentId(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        StudentId studentId = (StudentId) obj;
        return Objects.equals(value, studentId.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "StudentId{" + value + '}';
    }
}
