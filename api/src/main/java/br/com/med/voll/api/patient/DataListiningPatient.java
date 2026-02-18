package br.com.med.voll.api.patient;

public record DataListiningPatient(String name,
                                   String email,
                                   String cpf) {
    public DataListiningPatient(Patient patient) {
        this(
                patient.getName(),
                patient.getEmail(),
                patient.getCpf()
        );
    }

}
