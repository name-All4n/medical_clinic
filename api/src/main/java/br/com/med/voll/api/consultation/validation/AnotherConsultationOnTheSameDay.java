package br.com.med.voll.api.consultation.validation;

import br.com.med.voll.api.consultation.Consultation;
import br.com.med.voll.api.consultation.DataScheduleConsultation;
import br.com.med.voll.api.repository.ConsultationRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnotherConsultationOnTheSameDay implements  ValidationScheduleConsultation {
    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public void validation(DataScheduleConsultation data) {
        var firstTime = data.date().withHour(7);
        var lastTime = data.date().withHour(18);
        var AnotherConsultationOnTheSameDay = consultationRepository.existByPatientIdAndDateBetween(data.idPatient(), firstTime, lastTime);
        if (AnotherConsultationOnTheSameDay) {
            throw new ValidationException("patient already has a consultation on that day");
        }
    }
}
