package br.com.med.voll.api.consultation.validation;

import br.com.med.voll.api.consultation.DataScheduleConsultation;
import br.com.med.voll.api.infra.exeption.ValidationExeption;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class AdvanceTime implements ValidationScheduleConsultation {
    @Override
    public void validation(DataScheduleConsultation data){
        var dataConsultation = data.date();
        var now = LocalDateTime.now();
        var differenceInMinutes = Duration.between(now, dataConsultation).toMinutes();
        if (differenceInMinutes < 30) {
            throw new ValidationExeption("Consultations must be scheduled at least 30 minutes in advance.");
        }
    }
}
