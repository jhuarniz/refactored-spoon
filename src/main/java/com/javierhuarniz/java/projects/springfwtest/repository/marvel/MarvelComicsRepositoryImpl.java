package com.javierhuarniz.java.projects.springfwtest.repository.marvel;

import com.javierhuarniz.java.projects.springfwtest.beans.MarvelCredentials;
import com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.comic.Comic;
import com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.comic.ComicData;
import com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.comic.ComicDataWrapper;
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
public class MarvelComicsRepositoryImpl implements MarvelComicsRepository {

    private static final Logger logger = Logger.getLogger(MarvelComicsRepositoryImpl.class);
    private final String url;

    @Autowired
    private RestOperations restOperations;

    @Autowired
    public MarvelComicsRepositoryImpl(@Value("${marvel.v1.comics.service.url}") final String url) {
        this.url = url;
    }

    public List<Comic> load(MarvelCredentials credentials, int characterid) {
        List<Comic> response = new LinkedList<>();

        int offset = 0;
        int limit = 50;
        try {
            response = fetchPage(response, credentials, characterid, offset, limit);

        } catch (Exception e) {
            logger.error(e);
            return null;
        }
        return response;
    }

    private List<Comic> fetchPage(List<Comic> response, MarvelCredentials credentials, int characterid, int offset, int limit) {

        ResponseEntity<ComicDataWrapper> responseEntity = callService(credentials, characterid, offset, limit);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            ComicData data = responseEntity.getBody().getComicData();
            if (data != null) {
                response.addAll(Arrays.asList(data.getResults()));
                if (data.getTotal() > limit)
                    if (response.size() < data.getTotal())
                        fetchPage(response, credentials, characterid, offset + limit, limit);
            }
        }
        return response;

    }

    private ResponseEntity<ComicDataWrapper> callService(MarvelCredentials credentials, int characterid, int offset, int limit) {
        long ts = System.currentTimeMillis();
        String valueToDigest = ts + credentials.getPrivateKey() + credentials.getPublicKey();
        String hash = MarvelUtils.generateHash(valueToDigest.getBytes());
        Map<String, Object> urlVariables = new HashMap<>();
        urlVariables.put("characterid", characterid);
        urlVariables.put("timestamp", ts);
        urlVariables.put("apikey", credentials.getPublicKey());
        urlVariables.put("hash", hash);
        urlVariables.put("limit", limit);
        urlVariables.put("offset", offset);
        ResponseEntity<ComicDataWrapper> responseEntity = null;
        try {
            responseEntity = restOperations.getForEntity(this.url, ComicDataWrapper.class, urlVariables);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("erro obtendo a lista: " + urlVariables.toString(), e);
        } finally {
            return responseEntity;
        }
    }

}
