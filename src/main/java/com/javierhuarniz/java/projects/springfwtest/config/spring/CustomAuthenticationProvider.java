package com.javierhuarniz.java.projects.springfwtest.config.spring;

import com.javierhuarniz.java.projects.springfwtest.beans.MarvelCredentials;
import com.javierhuarniz.java.projects.springfwtest.service.CharactersService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by javier on 21/01/2017.
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final Logger logger = Logger.getLogger(CustomAuthenticationProvider.class);

    @Autowired
    CharactersService charactersService;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        try {

            charactersService.setCredentials(new MarvelCredentials(name, password));
            charactersService.loadCharacters();

            return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());

        } catch (Exception e) {
            logger.error("Login invalido.");
            return null;
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}