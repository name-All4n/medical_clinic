package br.com.med.voll.api.doctor;

import br.com.med.voll.api.address.DataAddress;
import jakarta.validation.constraints.NotNull;

public record DataUpdateDoctors(@NotNull Long id,
                                String name,
                                String telephone,
                                DataAddress address) {
}
