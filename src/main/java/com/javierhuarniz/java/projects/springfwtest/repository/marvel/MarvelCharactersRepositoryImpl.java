package com.javierhuarniz.java.projects.springfwtest.repository.marvel;

import com.javierhuarniz.java.projects.springfwtest.beans.MarvelCredentials;
import com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.character.Character;
import com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.character.CharacterData;
import com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.character.CharacterDataWrapper;
import com.javierhuarniz.java.projects.springfwtest.repository.marvel.utils.MarvelUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestOperations;

import java.util.*;

/**
 * Created by javier on 19/01/2017..
 */
@Repository
public class MarvelCharactersRepositoryImpl implements MarvelCharactersRepository {

    private static final Logger logger = Logger.getLogger(MarvelCharactersRepositoryImpl.class);

    private final String url;

    @Autowired
    private RestOperations restOperations;

    @Autowired
    public MarvelCharactersRepositoryImpl(@Value("${marvel.v1.characters.service.url}") final String url) {
        this.url = url;
    }

    public List<Character> load(MarvelCredentials credentials) {
        List<Character> response = new LinkedList<>();

        int offset = 0;
        int limit = 50;

        try {
            response = fetchPage(response, credentials, offset, limit);
        } catch (Exception e) {
            logger.error(e);
            return null;
        }
        return response;
    }

    private List<Character> fetchPage(List<Character> response, MarvelCredentials credentials, int offset, int limit) {

        ResponseEntity<CharacterDataWrapper> responseEntity = callService(credentials, offset, limit);

        if (responseEntity != null && responseEntity.getStatusCode().is2xxSuccessful()) {
            CharacterData data = responseEntity.getBody().getCharacterData();
            if (data != null) {
                response.addAll(Arrays.asList(data.getResults()));
                if (response.size() < data.getTotal())
                    fetchPage(response, credentials, offset + limit, limit);
            }

        }
        return response;

    }

    private ResponseEntity<CharacterDataWrapper> callService(MarvelCredentials credentials, int offset, int limit) {
        long ts = System.currentTimeMillis();
        String valueToDigest = ts + credentials.getPrivateKey() + credentials.getPublicKey();
        String hash = MarvelUtils.generateHash(valueToDigest.getBytes());
        Map<String, Object> urlVariables = new HashMap<>();
        urlVariables.put("timestamp", ts);
        urlVariables.put("apikey", credentials.getPublicKey());
        urlVariables.put("hash", hash);
        urlVariables.put("limit", limit);
        urlVariables.put("offset", offset);
        ResponseEntity<CharacterDataWrapper> responseEntity = null;
        try {
            responseEntity = restOperations.getForEntity(this.url, CharacterDataWrapper.class, urlVariables);
        } catch (Exception e) {
            logger.error("erro obtendo a lista: " + urlVariables.toString(), e);
        } finally {
            return responseEntity;
        }
    }


}
