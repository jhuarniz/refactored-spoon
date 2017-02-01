package com.javierhuarniz.java.projects.springfwtest.controller.rest.wrapper;

import com.javierhuarniz.java.projects.springfwtest.model.CharacterEntity;

/**
 * Created by javier on 20/01/2017..
 */
public class CharacterResponseWrapper {
    String status;
    CharacterEntity character;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CharacterEntity getCharacter() {
        return character;
    }

    public void setCharacter(CharacterEntity character) {
        this.character = character;
    }
}
