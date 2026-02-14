package br.com.med.voll.api.address;

public record DataAddress(String street,
                          String neighborhood,
                          String cep,
                          String city,
                          String uf,
                          String complement,
                          String number) {
}
