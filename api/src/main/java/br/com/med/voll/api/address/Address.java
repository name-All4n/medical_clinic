package br.com.med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    private String street;
    private String neighborhood;
    private String cep;
    private String city;
    private String uf;
    private String complement;
    private String number;

    public Address(DataAddress data) {
        this.street = data.street();
        this.neighborhood = data.neighborhood();
        this.cep = data.cep();
        this.city = data.city();
        this.uf = data.uf();
        this.complement = data.complement();
        this.number = data.number();
    }

    public void updateInformations(DataAddress address) {
        if (address.street() != null) {
            this.street = address.street();
        }
        if (address.neighborhood() != null) {
            this.neighborhood = address.neighborhood();
        }
        if (address.cep() != null) {
            this.cep = address.cep();
        }
        if (address.city() != null) {
            this.city = address.city();
        }
        if (address.uf() != null) {
            this.uf = address.uf();
        }
        if (address.complement() != null) {
            this.complement = address.complement();
        }
        if (address.number() != null) {
            this.number = address.number();
        }
    }
}
