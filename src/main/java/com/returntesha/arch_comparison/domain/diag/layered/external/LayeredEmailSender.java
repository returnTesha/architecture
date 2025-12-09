package com.returntesha.arch_comparison.domain.diag.layered.external;

import org.springframework.stereotype.Component;

// [External] 외부 시스템 (이메일 발송)
@Component
public class LayeredEmailSender {
    public void send(String to, String message) {
        // 실제로는 SMTP 연동이겠지만, 여기서는 로그로 대체
        System.out.println("📧 [Layered Mail] To: " + to + ", Msg: " + message);
    }
}
