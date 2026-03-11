package br.com.med.voll.api.repository;

import br.com.med.voll.api.doctor.Doctor;
import br.com.med.voll.api.doctor.Specialty;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Page<Doctor> findAllByActiveTrue(Pageable pagination);

    @Query("select m from Doctor m where m.active = true and m.specialty = :specialty and m.id not in(select c.doctor.id from Consultation c where c.date = :date) order by rand() limit 1")
    Doctor chooseRandomDoctor(Specialty specialty, LocalDateTime date);
}
