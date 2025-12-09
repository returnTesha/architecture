package com.returntesha.arch_comparison.domain.diag.hexagonal.application.service;

import com.returntesha.arch_comparison.domain.diag.hexagonal.application.port.input.DiagnosisApplicationService;
import com.returntesha.arch_comparison.domain.diag.hexagonal.application.port.output.NotificationSender;
import com.returntesha.arch_comparison.domain.diag.hexagonal.application.port.output.StudentRepository;
import com.returntesha.arch_comparison.domain.diag.hexagonal.domain.DiagnosisNotification;
import com.returntesha.arch_comparison.domain.diag.hexagonal.domain.Student;
import com.returntesha.arch_comparison.domain.diag.hexagonal.domain.StudentId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 애플리케이션 서비스 구현체
 * ✅ [장점] 비즈니스 로직 orchestration에 집중
 * ✅ [장점] 포트(인터페이스)에만 의존하여 구현체 교체 용이
 * ✅ [장점] 도메인 객체의 메서드를 호출하여 비즈니스 로직 위임
 */
@Service("hexagonalDiagnosisApplicationService")
@Transactional
public class DiagnosisApplicationServiceImpl implements DiagnosisApplicationService {

    private final StudentRepository studentRepository;
    private final NotificationSender notificationSender;

    public DiagnosisApplicationServiceImpl(
            StudentRepository studentRepository,
            NotificationSender notificationSender) {
        this.studentRepository = studentRepository;
        this.notificationSender = notificationSender;
    }

    @Override
    public void applyDiagnosis(StudentId studentId) {
        // 1. 학생 조회 (layered와 동일)
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException(
                    "해당 학생이 존재하지 않습니다. id=" + studentId.getValue()));

        // 2. 비즈니스 로직 실행 - 4학년 체크 (layered와 동일)
        student.validateDiagnosisEligibility();

        // 3.DB저장
        studentRepository.normalSave(student);

        // 4. 알림 발송 (layered와 동일한 로직, 단지 타입 안전한 객체 사용)
        DiagnosisNotification notification = new DiagnosisNotification(
            student.getProfessorEmail(),
            String.format("[%s] 학생이 역량 진단을 신청했습니다.", student.getName())
        );
        notificationSender.send(notification);
    }
}
