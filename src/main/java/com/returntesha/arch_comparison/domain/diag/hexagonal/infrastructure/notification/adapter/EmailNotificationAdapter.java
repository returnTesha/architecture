package com.returntesha.arch_comparison.domain.diag.hexagonal.infrastructure.notification.adapter;

import com.returntesha.arch_comparison.domain.diag.hexagonal.application.port.output.NotificationSender;
import com.returntesha.arch_comparison.domain.diag.hexagonal.domain.DiagnosisNotification;
import org.springframework.stereotype.Component;

/**
 * Secondary Adapter - 이메일 알림 포트 구현체
 * ✅ [장점] 도메인의 NotificationSender 포트를 이메일로 구현
 * ✅ [장점] 도메인은 이메일 전송 방식에 대해 모름
 * ✅ [장점] 나중에 SMS, Slack, 카카오톡 등으로 쉽게 교체 가능
 * ✅ [장점] 테스트 시 Mock으로 쉽게 대체 가능
 */
@Component
public class EmailNotificationAdapter implements NotificationSender {

    @Override
    public void send(DiagnosisNotification notification) {
        // 실제 환경에서는 SMTP 서버를 통한 이메일 발송
        // 여기서는 로그로 대체
        System.out.println("📧 [Hexagonal Mail] To: " + notification.getRecipient().getValue()
                          + ", Msg: " + notification.getMessage());

        // 실제 구현 예시:
        // emailClient.send(
        //     notification.getRecipient().getValue(),
        //     "진단 신청 알림",
        //     notification.getMessage()
        // );
    }
}
