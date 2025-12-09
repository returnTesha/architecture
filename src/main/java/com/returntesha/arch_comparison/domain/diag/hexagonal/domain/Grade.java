package com.returntesha.arch_comparison.domain.diag.hexagonal.domain;

import java.util.Objects;

/**
 * 학년 값 객체
 * ✅ [장점] 비즈니스 규칙이 값 객체 내부에 캡슐화됨
 */
public class Grade {
    private final Integer value;

    public Grade(Integer value) {
        this.value = value;
    }

    public boolean isFourthYear() {
        return value.equals(4);
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Grade grade = (Grade) obj;
        return Objects.equals(value, grade.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Grade{" + value + "학년}";
    }
}
