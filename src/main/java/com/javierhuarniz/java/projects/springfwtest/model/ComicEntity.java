package com.javierhuarniz.java.projects.springfwtest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

/**
 * Created by javier on 19/01/2017..
 */

@Entity
@Table(name = "comic_entity")
public class ComicEntity implements java.io.Serializable{

    @Id
    Integer  id;

    @Lob
    @Column(length = 100000)
    String title;
    double issueNumber;

    @Lob
    @Column(length = 100000)
    String description;

    @Lob
    @Column(length = 100000)
    String thumbnail;

    @ManyToOne(targetEntity = CharacterEntity.class, fetch = FetchType.LAZY)
    @JsonIgnoreProperties("comics")
    private CharacterEntity characterEntity;


    @JoinColumn( name = "id", nullable = false)
    public CharacterEntity getCharacterEntity() {
        return characterEntity;
    }

    public void setCharacterEntity(CharacterEntity characterEntity) {
        this.characterEntity = characterEntity;
    }

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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
