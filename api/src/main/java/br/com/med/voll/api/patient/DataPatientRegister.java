package br.com.med.voll.api.patient;

import br.com.med.voll.api.address.DataAddress;

public record DataPatientRegister(String name,
                                  String email,
                                  String telephone,
                                  String cpf,
                                  DataAddress address) {
}
