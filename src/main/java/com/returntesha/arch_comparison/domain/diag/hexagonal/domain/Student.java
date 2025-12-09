package com.returntesha.arch_comparison.domain.diag.hexagonal.domain;

/**
 * 헥사고날 아키텍처의 핵심 - 도메인 모델
 * ✅ [장점] 비즈니스 로직이 도메인 객체 내부에 캡슐화됨
 * ✅ [장점] 기술적 의존성(JPA, MyBatis 등)이 전혀 없음
 * ✅ [장점] 테스트하기 쉬움 (순수한 자바 객체)
 */
public class Student {
    private final StudentId id;
    private final String name;
    private final Grade grade;
    private final ProfessorEmail professorEmail;

    public Student(StudentId id, String name, Grade grade, ProfessorEmail professorEmail) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.professorEmail = professorEmail;
    }

    // ✅ [객체지향] 비즈니스 로직이 도메인 객체 안에 있음
    public boolean isSenior() {
        return grade.isFourthYear();
    }

    public void validateDiagnosisEligibility() {
        if (!isSenior()) {
            throw new DiagnosisNotAllowedException("4학년 학생만 진단 신청이 가능합니다.");
        }
    }

    // Getters
    public StudentId getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }

    public ProfessorEmail getProfessorEmail() {
        return professorEmail;
    }
}
