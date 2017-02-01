package com.javierhuarniz.java.projects.springfwtest.repository.marvel;

import com.javierhuarniz.java.projects.springfwtest.beans.MarvelCredentials;
import com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.character.Character;

import java.util.List;

/**
 * Created by javier on 21/01/2017.
 */
public interface MarvelCharactersRepository {
    public List<Character> load(MarvelCredentials credentials);
}
