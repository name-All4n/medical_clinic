package br.com.med.voll.api.infra.exeption;

public class ValidationExeption extends RuntimeException {
    public ValidationExeption(String message) {
        super(message);
    }
}
