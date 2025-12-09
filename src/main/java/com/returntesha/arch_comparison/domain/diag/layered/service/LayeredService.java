package com.returntesha.arch_comparison.domain.diag.layered.service;

import com.returntesha.arch_comparison.domain.diag.layered.entity.StudentEntity;
import com.returntesha.arch_comparison.domain.diag.layered.external.LayeredEmailSender;
import com.returntesha.arch_comparison.domain.diag.layered.repository.LayeredRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LayeredService {
    // ❌ [단점] Service가 구체적인 기술(MyBatis Mapper, EmailSender)을 직접 알고 있음
    // 나중에 JPA로 바꾸거나, 이메일을 카톡으로 바꾸려면 이 코드를 수정해야 함.
    private final LayeredRepository layeredRepository;
    private final LayeredEmailSender emailSender;

    @Transactional
    public void applyDiagnosis(Long studentId) {
        // 1. DB에서 데이터 가져오기 (VO를 바로 사용)
        StudentEntity studentEntity = layeredRepository.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("해당 학생이 존재하지 않습니다. id=" + studentId));

        // 2. 비즈니스 로직 (4학년 체크)
        // 객체지향적인 student.isSenior()가 아니라, 데이터를 꺼내서 비교하는 절차지향적 코드
        if (studentEntity.getGrade() != 4) {
            throw new IllegalStateException("4학년 학생만 진단 신청이 가능합니다.");
        }

        // 3. DB 저장
        layeredRepository.save(studentEntity);

        // 4. 외부 알림 전송
        // 테스트 시 이메일 서버가 없으면 에러가 남 (테스트하기 어려움)
        emailSender.send(studentEntity.getProfessorEmail(),
                String.format("[%s] 학생이 역량 진단을 신청했습니다.", studentEntity.getName()));
    }
}
