package com.javierhuarniz.java.projects.springfwtest.repository.marvel;

import com.javierhuarniz.java.projects.springfwtest.beans.MarvelCredentials;
import com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.character.Character;
import com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.comic.Comic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by javier on 21/01/2017.
 */

@Repository
public class MarvelRepositoryFacade {

    @Autowired
    MarvelCharactersRepository marvelCharactersRepository;

    @Autowired
    MarvelComicsRepository marvelComicsRepository;

    public List<Character> loadCharacters(MarvelCredentials credentials) {
        return marvelCharactersRepository.load(credentials);
    }

    public List<Comic> loadComics(MarvelCredentials credentials, int charactedId) {
        return marvelComicsRepository.load(credentials, charactedId);
    }

}
