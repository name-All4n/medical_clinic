package br.com.med.voll.api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DataAddress(@NotBlank String street,
                          @NotBlank String neighborhood,
                          @NotBlank @Pattern(
                                  regexp = "\\d{8}") String cep,
                          @NotBlank String city,
                          @NotBlank String uf,
                          String complement,
                          String number) {
}
