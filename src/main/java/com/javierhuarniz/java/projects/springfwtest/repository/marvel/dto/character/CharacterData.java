package com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.character;

/**
 * Created by javier on 19/01/2017..
 */
public class CharacterData {

    int offset;
    int total;
    int count;
    Character[] results;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Character[] getResults() {
        return results;
    }

    public void setResults(Character[] results) {
        this.results = results;
    }
}
