package br.com.med.voll.api.doctor;

import br.com.med.voll.api.address.DataAddress;

public record DataDoctorRegister(String name,
                                 String email,
                                 String crm,
                                 Specialty specialty,
                                 DataAddress address) {
}
