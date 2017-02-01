package com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.comic;

import com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.Image;

/**
 * Created by javier on 19/01/2017..
 */
public class Comic {

    int id;
    String title;
    double issueNumber;
    String description;
    Image thumbnail;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(double issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }
}
