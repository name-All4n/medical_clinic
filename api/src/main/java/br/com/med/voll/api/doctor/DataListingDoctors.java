package br.com.med.voll.api.doctor;

public record DataListingDoctors(Long id,
                                 String name,
                                 String email,
                                 String crm,
                                 Specialty specialty) {

    public DataListingDoctors(Doctor doctor) {
        this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
    }
}
