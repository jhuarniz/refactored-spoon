package com.javierhuarniz.java.projects.springfwtest.controller.web;


import com.javierhuarniz.java.projects.springfwtest.model.CharacterEntity;
import com.javierhuarniz.java.projects.springfwtest.service.CharactersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by javier on 28/01/2017..
 */
@Controller
public class CharacterController {

    @Autowired
    CharactersService charactersService;

    @RequestMapping(value = "/characters", method = RequestMethod.GET)
    public String listCharacters(Model model) {
        return "redirect:/characters/page/1";

    }

    @RequestMapping(value="/characters/page/{pageNumber}", method = RequestMethod.GET)
    public String getPagedCharacterList(Model model, @PathVariable Integer pageNumber) {
        int pageSize = 10;

        Page<CharacterEntity> a = charactersService.getPaged(pageNumber -1, pageSize);


        int current = pageNumber;
        int begin = Math.max(1, current - pageSize);
        int end = Math.min(begin + pageSize, a.getTotalPages());
        int totalPageCount = a.getTotalPages();

        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("totalPageCount", totalPageCount);

        model.addAttribute("baseUrl", "/characters/page/");
        model.addAttribute("characters", a.getContent());
        return "characters";

    }


    @RequestMapping(value = "/character/{id}", method = RequestMethod.GET)
    public String listCharacters(@PathVariable Integer id, Model model) {
        model.addAttribute("character", charactersService.getDetail(id));
        return "character";

    }

}
