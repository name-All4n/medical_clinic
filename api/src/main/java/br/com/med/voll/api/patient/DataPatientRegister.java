package br.com.med.voll.api.patient;

import br.com.med.voll.api.address.DataAddress;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DataPatientRegister(@NotBlank String name,
                                  @NotBlank @Email String email,
                                  @NotBlank String telephone,
                                  @NotBlank @Pattern(regexp = "\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}") String cpf,
                                  @NotNull @Valid DataAddress address) {
}
