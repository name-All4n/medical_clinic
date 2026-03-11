package br.com.med.voll.api.consultation;

import br.com.med.voll.api.doctor.Doctor;
import br.com.med.voll.api.infra.exeption.ValidationExeption;
import br.com.med.voll.api.repository.ConsultationRepository;
import br.com.med.voll.api.repository.DoctorRepository;
import br.com.med.voll.api.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleConsultation {
    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    public void schedule(DataScheduleConsultation data) {
        if (!patientRepository.existsById(data.idPatient())) {
            throw new ValidationExeption("The patient ID does not exist.");
        }
        if (data.idDoctor() != null && !doctorRepository.existsById(data.idDoctor())) {
            throw new ValidationExeption("The doctor ID does not exist.");
        }

        var patient = patientRepository.getReferenceById(data.idPatient());
        var doctor = chooseDoctor(data);
        var consultation = new Consultation(null, doctor, patient, data.date());
        consultationRepository.save(consultation);
    }

    private Doctor chooseDoctor(DataScheduleConsultation data) {
        if (data.idDoctor() != null) {
            return doctorRepository.getReferenceById(data.idDoctor());
        }
        if (data.specialty() == null) {
            throw new ValidationExeption("The specialty is mandatory!");
        }
        return doctorRepository.chooseRandomDoctor(data.specialty(), data.date());
    }
}
