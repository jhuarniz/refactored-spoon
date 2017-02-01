package com.javierhuarniz.java.projects.springfwtest.service;

import com.javierhuarniz.java.projects.springfwtest.beans.MarvelCredentials;
import com.javierhuarniz.java.projects.springfwtest.model.CharacterEntity;
import com.javierhuarniz.java.projects.springfwtest.model.ComicEntity;
import com.javierhuarniz.java.projects.springfwtest.repository.marvel.MarvelRepositoryFacade;
import com.javierhuarniz.java.projects.springfwtest.repository.persistence.CharactersRepository;
import com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.character.Character;
import com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.comic.Comic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by javier on 19/01/2017..
 */
@Service
public class MarvelCharactersService implements CharactersService {

    @Autowired
    MarvelRepositoryFacade marvelRepositoryFacade;

    @Autowired
    CharactersRepository charactersRepository;

    //Aqui teve problema para manter as credenciais na sessao.
    MarvelCredentials credentials;

    public void setCredentials(MarvelCredentials credentials) {
        this.credentials = credentials;
    }

    public void loadCharacters() {

        //deletamos da tabela em memoria
        clearCharacters();

        List<Character> response = marvelRepositoryFacade.loadCharacters(credentials);
        for (Character character : response) {
            CharacterEntity ch = new CharacterEntity();
            ch.setId(character.getId());
            ch.setDescription(character.getDescription());
            ch.setModified(character.getModified());
            ch.setName(character.getName());

            if (character.getThumbnail() != null)
                ch.setThumbnail(character.getThumbnail().getPath() + "." + character.getThumbnail().getExtension());

            if (character.getComics().getAvailable() != 0 && !StringUtils.isEmpty(character.getComics().getCollectionURI())) {
                ch.setHasComics(true);
            } else {
                ch.setHasComics(false);
            }

            charactersRepository.save(ch);
        }
    }

    public void clearCharacters() {
        charactersRepository.deleteAll();
    }


    @Override
    public Page<CharacterEntity> getPaged(int pageNumber, int pageSize) {
        return charactersRepository.findAll(new PageRequest(pageNumber, pageSize));
    }

    @Override
    public List<CharacterEntity> getAll() {
        return charactersRepository.findAll();
    }

    @Override
    public CharacterEntity getDetail(Integer id) {

        try {
            CharacterEntity characterEntity = charactersRepository.getOne(id);
            if (characterEntity.getHasComics() && characterEntity.getComics().isEmpty()) {
                //nao tem comics registrados, procuramos no rest

                List<Comic> comics = marvelRepositoryFacade.loadComics(credentials, characterEntity.getId());
                Set jpacomics = new HashSet<ComicEntity>();
                for (Comic comic :
                        comics) {
                    ComicEntity comicEntity = new ComicEntity();
                    comicEntity.setId(comic.getId());
                    comicEntity.setTitle(comic.getTitle());
                    if (comic.getThumbnail() != null) {
                        comicEntity.setThumbnail(comic.getThumbnail().getPath() + "." + comic.getThumbnail().getExtension());
                    }
                    comicEntity.setDescription(comic.getDescription());
                    comicEntity.setIssueNumber(comic.getIssueNumber());
                    comicEntity.setCharacterEntity(characterEntity);
                    jpacomics.add(comicEntity);
                    characterEntity.getComics().add(comicEntity);
                }
                charactersRepository.save(jpacomics);
                //charactersRepository.save(characterEntity);
                charactersRepository.flush();
            }
            return characterEntity;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
