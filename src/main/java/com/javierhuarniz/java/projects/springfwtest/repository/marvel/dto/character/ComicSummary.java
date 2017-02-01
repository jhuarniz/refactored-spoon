package com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.character;

/**
 * Created by javier on 19/01/2017..
 */
public class ComicSummary {
    String resourceURI;
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }
}
