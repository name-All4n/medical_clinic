package br.com.med.voll.api.patient;

import br.com.med.voll.api.address.DataAddress;
import jakarta.validation.Valid;

public record DataUpdatePatient(Long id,
                                String name,
                                String telephone,
                                @Valid DataAddress address) {
}
