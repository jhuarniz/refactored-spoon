package com.javierhuarniz.java.projects.springfwtest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

/**
 * Created by javier on 19/01/2017..
 */

@Entity
@Table(name = "character_entity")
public class CharacterEntity implements java.io.Serializable {

    @Id
    Integer id;

    @Column(length = 255)
    String name;

    @Lob
    @Column(length = 100000)
    String description;


    @Lob
    @Column(length = 100000)
    String thumbnail;

    Date modified;

    Boolean hasComics;

    @OneToMany(targetEntity = ComicEntity.class, fetch = FetchType.LAZY, mappedBy = "characterEntity", orphanRemoval = true)
    @JsonIgnoreProperties("characterEntity")
    private List<ComicEntity> comics = new LinkedList<ComicEntity>();

    public List<ComicEntity> getComics() {
        return this.comics;
    }

    public void setComics(List<ComicEntity> comics) {
        this.comics = comics;
    }

    public Boolean getHasComics() {
        return hasComics;
    }

    public void setHasComics(Boolean hasComics) {
        this.hasComics = hasComics;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
