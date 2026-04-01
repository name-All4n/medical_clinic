package br.com.med.voll.api.repository;

import br.com.med.voll.api.patient.Patient;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Page<Patient> findAllByActiveTrue(Pageable pagination);

    @Query("select p.active from Patient p where p.id = :id")
    Boolean findActiveById(@NotNull Long id);
}
