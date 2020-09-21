package com.example.demo.controller;

import com.example.demo.model.Film;
import com.example.demo.service.FilmService;
import com.example.demo.service.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
public class AdminController {

    private final FilmServiceImpl filmServiceImpl;

    @Autowired
    public AdminController(FilmServiceImpl filmServiceImpl) {
        this.filmServiceImpl = filmServiceImpl;
    }

    @GetMapping("/editFilm")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String editFilms() {
        return "editFilm";
    }

    @PostMapping("/addFilm")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addFilm(Film film) {
        filmServiceImpl.addFilm(film);
        return "editFilm";
    }




}
