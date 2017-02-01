package com.javierhuarniz.java.projects.springfwtest;

import org.h2.util.IOUtils;
import org.springframework.boot.json.JsonJsonParser;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Map;

/**
 * Created by javier on 28/01/2017..
 */
@Service
public class Characters {

    void Characters(){

    }

    public void firstLoad(){
        InputStream a = Characters.class.getResourceAsStream("characters.json");

        JsonJsonParser parser = new JsonJsonParser();
        try {
            Map<String, Object> map = parser.parseMap(IOUtils.readStringAndClose(IOUtils.getReader(a), 0));
            System.out.println(map);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
