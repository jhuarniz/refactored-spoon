package com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto;

/**
 * Created by javier on 19/01/2017..
 */
public class ResourceList {
    int available;
    int returned;
    String collectionURI;

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }
}
