package br.com.med.voll.api.consultation;

import java.time.LocalDateTime;

public record DataDetailsConsultation(Long id, Long idDoctor, Long idPatient, LocalDateTime date) {
    public DataDetailsConsultation(Consultation consultation) {
        this(consultation.getId(), consultation.getDoctor().getId(), consultation.getPatient().getId(), consultation.getDate());
    }
}
