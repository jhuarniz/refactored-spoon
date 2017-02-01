package com.javierhuarniz.java.projects.springfwtest.controller.web;


import com.javierhuarniz.java.projects.springfwtest.beans.MarvelCredentials;
import com.javierhuarniz.java.projects.springfwtest.service.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by javier on 28/01/2017..
 */
@Controller
public class LoginController {

    @Autowired
    CharactersService charactersService;

    @RequestMapping(value="/login",method= RequestMethod.GET)
    public String displayLogin(Model model){
        model.addAttribute("credentials", new MarvelCredentials());
        return "index";

    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String processLogin(MarvelCredentials credentials){
        charactersService.setCredentials(credentials); //Aqui teve problemas para colocar o credentials como atributo de sessao, usando isto como workaround
        charactersService.loadCharacters();
        return "redirect:/characters";
    }
}
