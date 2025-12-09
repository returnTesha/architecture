package com.returntesha.arch_comparison.domain.diag.hexagonal.domain;

import java.util.Objects;
import java.util.regex.Pattern;

/**
 * 교수 이메일 값 객체
 * ✅ [장점] 이메일 정보의 타입 안전성 확보
 */
public class ProfessorEmail {
    private final String value;

    public ProfessorEmail(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ProfessorEmail that = (ProfessorEmail) obj;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "ProfessorEmail{" + value + '}';
    }
}
