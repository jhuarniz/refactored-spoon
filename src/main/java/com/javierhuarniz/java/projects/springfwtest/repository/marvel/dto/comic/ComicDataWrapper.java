package com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.comic;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by javier on 19/01/2017..
 */
public class ComicDataWrapper {
    int code;
    String status;

    @JsonProperty("data")
    ComicData data;

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

    public ComicData getComicData() {
        return data;
    }

    public void setComicData(ComicData comicData) {
        this.data = comicData;
    }
}
