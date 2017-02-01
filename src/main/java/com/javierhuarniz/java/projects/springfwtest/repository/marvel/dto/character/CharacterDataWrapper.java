package com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.character;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by javier on 19/01/2017..
 */
public class CharacterDataWrapper {
    int code;
    String status;

    @JsonProperty("data")
    CharacterData data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public CharacterData getCharacterData() {
        return data;
    }

    public void setCharacterData(CharacterData characterData) {
        this.data = characterData;
    }
}
