package com.javierhuarniz.java.projects.springfwtest.repository.persistence;

import com.javierhuarniz.java.projects.springfwtest.model.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by javier on 19/01/2017..
 */
@Repository
public interface CharactersRepository extends JpaRepository<CharacterEntity, Integer> {

}
