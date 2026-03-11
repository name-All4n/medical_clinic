package br.com.med.voll.api.consultation;

import br.com.med.voll.api.doctor.Specialty;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DataScheduleConsultation(Long idDoctor,
                                       @NotNull
                                       Long idPatient,
                                       @NotNull
                                       @Future
                                       LocalDateTime date,
                                       Specialty specialty) {
}
