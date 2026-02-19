package br.com.med.voll.api.patient;

public record DataListiningPatient(Long id,
                                   String name,
                                   String email,
                                   String cpf) {
    public DataListiningPatient(Patient patient) {
        this(
                patient.getId(),
                patient.getName(),
                patient.getEmail(),
                patient.getCpf()
        );
    }

}
