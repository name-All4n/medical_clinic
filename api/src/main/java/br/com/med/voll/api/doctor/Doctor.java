package br.com.med.voll.api.doctor;

import br.com.med.voll.api.address.Address;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name="doctors")
@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private  String telephone;
    private String crm;
    @Enumerated(EnumType.STRING)
    private Specialty specialty;
    @Embedded
    private Address address;
    private Boolean active;

    public Doctor(DataDoctorRegister data) {
        this.active = true;
        this.name = data.name();
        this.email = data.email();
        this.telephone = data.telephone();
        this.crm = data.crm();
        this.specialty = data.specialty();
        this.address = new Address(data.address());
    }

    public void uptadeInformations(DataUpdateDoctors data) {
        if (this.name != null) {
            this.name = data.name();
        }
        if (this.telephone != null) {
            this.telephone = data.telephone();
        }
        if (this.address != null) {
            this.address.updateInformations(data.address());
        }

    }

    public void delete() {
        this.active = false;
    }
}
