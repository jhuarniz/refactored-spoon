package com.javierhuarniz.java.projects.springfwtest.controller.rest.wrapper;

import com.javierhuarniz.java.projects.springfwtest.model.CharacterEntity;

import java.util.List;

/**
 * Created by javier on 20/01/2017..
 */
public class CharacterListResponseWrapper {
    int quantidade;
    List<CharacterEntity> personagens;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public List<CharacterEntity> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<CharacterEntity> personagens) {
        this.personagens = personagens;
    }
}
