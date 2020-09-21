package com.example.demo.controller;

import com.example.demo.model.Film;
import com.example.demo.service.FilmServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdminRestController {

    private final FilmServiceImpl filmServiceImpl;

    @Autowired
    public AdminRestController(FilmServiceImpl filmServiceImpl) {
        this.filmServiceImpl = filmServiceImpl;
    }

    @DeleteMapping("/deleteFilm/{idFilm}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteFilms(@PathVariable String idFilm) {
        filmServiceImpl.deleteFilm(Long.parseLong(idFilm));
    }

    @PutMapping("/updateFilm")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void updateFilms(@RequestBody Film film) {
        filmServiceImpl.updateFilm(film);
    }
}
