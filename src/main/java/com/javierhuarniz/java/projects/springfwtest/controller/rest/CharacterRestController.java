package com.javierhuarniz.java.projects.springfwtest.controller.rest;

import com.javierhuarniz.java.projects.springfwtest.controller.rest.wrapper.CharacterListResponseWrapper;
import com.javierhuarniz.java.projects.springfwtest.controller.rest.wrapper.CharacterResponseWrapper;
import com.javierhuarniz.java.projects.springfwtest.model.CharacterEntity;
import com.javierhuarniz.java.projects.springfwtest.service.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by javier on 20/01/2017..
 */
@RestController
public class CharacterRestController {

    @Autowired
    CharactersService charactersService;

    @RequestMapping(value = "/api/character", method = RequestMethod.GET)
    public CharacterListResponseWrapper getCharacters() {
        CharacterListResponseWrapper wrapper = new CharacterListResponseWrapper();
        List<CharacterEntity> chars = charactersService.getAll();
        wrapper.setQuantidade(chars.size());
        wrapper.setPersonagens(chars);
        return wrapper;
    }

    @RequestMapping(value = "/api/character/{id}", method = RequestMethod.GET)
    public CharacterResponseWrapper getCharacters(@PathVariable(name = "id") int id) {


        CharacterResponseWrapper wrapper = new CharacterResponseWrapper();
        CharacterEntity chars = charactersService.getDetail(id);
        if (chars == null) {
            wrapper.setStatus("NOT_FOUND");
        } else {
            wrapper.setStatus("OK");
            wrapper.setCharacter(chars);
        }

        return wrapper;
    }
}
