package br.com.med.voll.api.user;

import org.springframework.security.authentication.AuthenticationManager;

public record DataAutentication(String login, String password) {
}
