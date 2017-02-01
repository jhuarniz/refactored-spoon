package com.javierhuarniz.java.projects.springfwtest.controller.web;

import com.javierhuarniz.java.projects.springfwtest.beans.MarvelCredentials;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by javier on 21/01/2017.
 */
@Controller
public class DefaultController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("credentials", new MarvelCredentials());
        return "index";
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String handleNotFound() {
        return "error";
    }
}
