package com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.character;

import com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.ResourceList;

import java.util.List;

/**
 * Created by javier on 19/01/2017..
 */
public class ComicList extends ResourceList {
    List<ComicSummary> items;

    public List<ComicSummary> getItems() {
        return items;
    }

    public void setItems(List<ComicSummary> items) {
        this.items = items;
    }
}
