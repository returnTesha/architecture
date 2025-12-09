package com.returntesha.arch_comparison.domain.diag.hexagonal.domain;

/**
 * 진단 신청 불가 예외
 * ✅ [장점] 도메인 전용 예외로 비즈니스 의미가 명확
 * ✅ [장점] 기술적 예외와 비즈니스 예외의 분리
 */
public class DiagnosisNotAllowedException extends RuntimeException {
    public DiagnosisNotAllowedException(String message) {
        super(message);
    }

    public DiagnosisNotAllowedException(String message, Throwable cause) {
        super(message, cause);
    }
}
