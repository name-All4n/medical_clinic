package br.com.med.voll.api.patient;


import br.com.med.voll.api.address.Address;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String telephone;
    @Embedded
    private Address address;
    private Boolean active;

    public Patient(DataPatientRegister data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.cpf = data.cpf();
        this.telephone = data.telephone();
        this.address = new  Address(data.address());
    }

    public void updateInformations(DataUpdatePatient data) {
        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.telephone() != null) {
            this.telephone = data.telephone();
        }
        if (data.address() != null) {
            address.updateInformations(data.address());
        }
    }

    public void delete() {
        this.active = false;
    }

}

