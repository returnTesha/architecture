package com.returntesha.arch_comparison.domain.diag.layered.web;

import com.returntesha.arch_comparison.domain.diag.layered.service.LayeredService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/layered/diagnosis")
@RequiredArgsConstructor
public class LayeredController {

    private final LayeredService layeredService;

    // POST /api/layered/diagnosis/apply/1
    @PostMapping("/apply/{studentId}")
    public String apply(@PathVariable Long studentId) {
        layeredService.applyDiagnosis(studentId);
        return "진단 신청이 완료되었습니다. (Layered Architecture)";
    }
}
