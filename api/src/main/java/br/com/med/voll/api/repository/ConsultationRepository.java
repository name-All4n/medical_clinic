package br.com.med.voll.api.repository;

import br.com.med.voll.api.consultation.Consultation;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultationRepository  extends JpaRepository<Consultation, Long> {

    boolean existsByDoctorIdAndDate(Long doctorId, LocalDateTime date);

    boolean existsByPatientIdAndDateBetween(Long PatientId, LocalDateTime firstTime, LocalDateTime lastTime);
}
