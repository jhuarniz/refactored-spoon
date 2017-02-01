package com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.character;

import com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.Image;
import com.javierhuarniz.java.projects.springfwtest.repository.marvel.dto.Url;

import java.util.Date;

/**
 * Created by javier on 19/01/2017..
 */
public class Character {
    int id;//(int, optional): The unique ID of the character resource.,
    String name;//(string, optional): The name of the character.,
    String description;// (string, optional): A short bio or description of the character.,
    Date modified;//(Date, optional): The date the resource was most recently modified.,
    String resourceURI;// (string, optional): The canonical URL identifier for this resource.,
    Url[] urls; //(Array[Url], optional): A set of public web site URLs for the resource.,
    Image thumbnail;// (Image, optional): The representative image for this character.,
    ComicList comics;// (ComicList, optional): A resource list containing comics which feature this character.,
    //stories (StoryList, optional): A resource list of stories in which this character appears.,
    ///events (EventList, optional): A resource list of events in which this character appears.,
    //series (SeriesList, optional): A resource list of series in which this character appears.


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public Url[] getUrls() {
        return urls;
    }

    public void setUrls(Url[] urls) {
        this.urls = urls;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ComicList getComics() {
        return comics;
    }

    public void setComics(ComicList comics) {
        this.comics = comics;
    }
}
