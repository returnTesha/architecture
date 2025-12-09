package com.returntesha.arch_comparison.domain.diag.hexagonal.application.port.input;

import com.returntesha.arch_comparison.domain.diag.hexagonal.domain.StudentId;

/**
 * 입력 포트 (Primary Port) - 비즈니스 유스케이스 인터페이스
 * ✅ [장점] 비즈니스 로직의 진입점을 명확히 정의
 * ✅ [장점] 웹, CLI, 메시징 등 다양한 방식으로 호출 가능
 * ✅ [장점] 유스케이스가 명확하게 드러남
 */
public interface DiagnosisApplicationService {

    /**
     * 진단 신청 유스케이스
     * @param studentId 학생 ID
     */
    void applyDiagnosis(StudentId studentId);
}
