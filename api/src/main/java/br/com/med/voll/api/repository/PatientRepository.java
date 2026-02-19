package br.com.med.voll.api.repository;

import br.com.med.voll.api.patient.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findAllByActiveTrue(Pageable pagination);
}
