package com.returntesha.arch_comparison.domain.diag.hexagonal.infrastructure.web.adapter;

import com.returntesha.arch_comparison.domain.diag.hexagonal.application.port.input.DiagnosisApplicationService;
import com.returntesha.arch_comparison.domain.diag.hexagonal.domain.StudentId;
import org.springframework.web.bind.annotation.*;

/**
 * Primary Adapter - 웹 컨트롤러
 * ✅ [장점] 도메인의 DiagnosisApplicationService 포트를 웹으로 노출
 * ✅ [장점] 도메인은 HTTP 요청/응답에 대해 모름
 * ✅ [장점] 나중에 GraphQL, gRPC 등으로 쉽게 추가 가능
 * ✅ [장점] 웹과 도메인의 완전한 분리
 */
@RestController
@RequestMapping("/api/hexagonal/diagnosis")
public class HexagonalDiagnosisController {

    private final DiagnosisApplicationService diagnosisApplicationService;

    public HexagonalDiagnosisController(DiagnosisApplicationService diagnosisApplicationService) {
        this.diagnosisApplicationService = diagnosisApplicationService;
    }

    /**
     * 진단 신청 API
     * POST /api/hexagonal/diagnosis/apply/1
     */
    @PostMapping("/apply/{studentId}")
    public String applyDiagnosis(@PathVariable Long studentId) {
        // HTTP 파라미터를 도메인 값 객체로 변환
        StudentId domainStudentId = new StudentId(studentId);

        // 애플리케이션 서비스 호출 (도메인 언어 사용)
        diagnosisApplicationService.applyDiagnosis(domainStudentId);

        return "진단 신청이 완료되었습니다. (Hexagonal Architecture)";
    }
}
