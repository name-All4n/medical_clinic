package br.com.med.voll.api.repository;

import br.com.med.voll.api.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
