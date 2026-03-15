package br.com.med.voll.api.controller;

import br.com.med.voll.api.consultation.DataDetailsConsultation;
import br.com.med.voll.api.consultation.DataScheduleConsultation;
import br.com.med.voll.api.consultation.ScheduleConsultation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultation")
@SecurityRequirement(name = "bearer-key")
public class ConsultationController {
    @Autowired
    private ScheduleConsultation scheduleConsultation;

    @PostMapping
    @Transactional
    public ResponseEntity schedule(@RequestBody @Valid DataScheduleConsultation data) {
        var dto = scheduleConsultation.schedule(data);
        return ResponseEntity.ok(dto);
    }
}
