package br.com.med.voll.api.repository;

import br.com.med.voll.api.consultation.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository  extends JpaRepository<Consultation, Integer> {

}
