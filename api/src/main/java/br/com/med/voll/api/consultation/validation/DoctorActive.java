package br.com.med.voll.api.consultation.validation;

import br.com.med.voll.api.consultation.DataScheduleConsultation;
import br.com.med.voll.api.infra.exeption.ValidationExeption;
import br.com.med.voll.api.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DoctorActive implements ValidationScheduleConsultation {
    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void validation(DataScheduleConsultation data) {
        if (data.idDoctor() == null) {
            return;
        }

        var doctorAreActive = doctorRepository.findActiveById(data.idDoctor());
        if (!doctorAreActive) {
            throw new ValidationExeption("consultations can't be schedule with doctor inactive");
        }

    }

}
