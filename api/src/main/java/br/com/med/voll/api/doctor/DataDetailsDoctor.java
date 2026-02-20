package br.com.med.voll.api.doctor;

import br.com.med.voll.api.address.Address;

public record DataDetailsDoctor(Long id, String name, String email, String crm, String telephone, Specialty specialty, Address address) {
    public DataDetailsDoctor(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getTelephone(),doctor.getSpecialty(), doctor.getAddress() );
    }


}
