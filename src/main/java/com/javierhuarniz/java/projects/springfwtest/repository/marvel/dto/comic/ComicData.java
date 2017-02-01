package com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.comic;

/**
 * Created by javier on 19/01/2017..
 */
public class ComicData {

    int offset;
    int total;
    int count;
    Comic[] results;

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

    public Comic[] getResults() {
        return results;
    }

    public void setResults(Comic[] results) {
        this.results = results;
    }
}
