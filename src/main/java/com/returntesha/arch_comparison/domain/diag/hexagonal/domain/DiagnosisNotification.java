package com.returntesha.arch_comparison.domain.diag.hexagonal.domain;

import java.util.Objects;

/**
 * 진단 알림 값 객체
 * ✅ [장점] 알림에 필요한 정보를 캡슐화
 * ✅ [장점] 불변 객체로 안전성 확보
 */
public class DiagnosisNotification {
    private final ProfessorEmail recipient;
    private final String message;

    public DiagnosisNotification(ProfessorEmail recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    public ProfessorEmail getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DiagnosisNotification that = (DiagnosisNotification) obj;
        return Objects.equals(recipient, that.recipient) &&
               Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipient, message);
    }

    @Override
    public String toString() {
        return "DiagnosisNotification{" +
               "recipient=" + recipient +
               ", message='" + message + '\'' +
               '}';
    }
}
