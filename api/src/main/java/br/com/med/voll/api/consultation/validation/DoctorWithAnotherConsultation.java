package br.com.med.voll.api.consultation.validation;

import br.com.med.voll.api.consultation.Consultation;
import br.com.med.voll.api.consultation.DataScheduleConsultation;
import br.com.med.voll.api.infra.exeption.ValidationExeption;
import br.com.med.voll.api.repository.ConsultationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorWithAnotherConsultation implements ValidationScheduleConsultation{
    @Autowired
    private ConsultationRepository repository;


    @Override
    public void validation(DataScheduleConsultation data){
        var ConsultationsInTheSameTime = repository.existsByDoctorIdAndDate(data.idDoctor(), data.date());
        if (ConsultationsInTheSameTime) {
            throw new ValidationExeption("Doctor already has another consultation at the same time");
        }
    }
}
