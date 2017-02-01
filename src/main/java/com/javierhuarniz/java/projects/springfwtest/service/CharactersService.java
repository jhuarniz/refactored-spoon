package com.javierhuarniz.java.projects.springfwtest.service;

import com.javierhuarniz.java.projects.springfwtest.beans.MarvelCredentials;
import com.javierhuarniz.java.projects.springfwtest.model.CharacterEntity;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by javier on 19/01/2017..
 */
public interface CharactersService {

    public void loadCharacters();

    void setCredentials(MarvelCredentials credentials);

    public List<CharacterEntity> getAll();

    CharacterEntity getDetail(Integer id);

    public Page<CharacterEntity> getPaged(int pageNumber, int pageSize);

}
