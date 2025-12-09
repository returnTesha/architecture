package com.returntesha.arch_comparison.domain.diag.hexagonal.application.port.output;

import com.returntesha.arch_comparison.domain.diag.hexagonal.domain.DiagnosisNotification;

/**
 * 출력 포트 (Secondary Port) - 알림 발송 인터페이스
 * ✅ [장점] 도메인이 구체적인 알림 방식(이메일, SMS, 슬랙 등)에 의존하지 않음
 * ✅ [장점] 알림 방식을 자유롭게 변경 가능
 * ✅ [장점] 테스트 시 Mock으로 쉽게 대체 가능
 */
public interface NotificationSender {

    /**
     * 진단 신청 알림 발송
     * @param notification 발송할 알림 정보
     */
    void send(DiagnosisNotification notification);
}
