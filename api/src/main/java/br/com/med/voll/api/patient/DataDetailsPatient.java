package br.com.med.voll.api.patient;

import br.com.med.voll.api.address.Address;

public record DataDetailsPatient(String name, String email, String telephone, String cpf, Address address) {
    public DataDetailsPatient(Patient patient) {
        this(patient.getName(), patient.getEmail(), patient.getTelephone(), patient.getCpf(), patient.getAddress());
    }
}
