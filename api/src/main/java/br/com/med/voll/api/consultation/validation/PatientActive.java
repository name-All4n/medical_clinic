package br.com.med.voll.api.consultation.validation;

import br.com.med.voll.api.consultation.DataScheduleConsultation;
import br.com.med.voll.api.infra.exeption.ValidationExeption;
import br.com.med.voll.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientActive implements ValidationScheduleConsultation{
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void validation(DataScheduleConsultation data) {
        var patientAreActive = patientRepository.findActiveById(data.idPatient());
        if (!patientAreActive) {
            throw new ValidationExeption("Consultation can't be scheduled with excluded patient");
        }
    }
}
