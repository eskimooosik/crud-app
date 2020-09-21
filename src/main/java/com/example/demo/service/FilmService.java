package com.example.demo.service;

import com.example.demo.model.Film;

import java.util.List;

public interface FilmService {
    void addFilm(Film film);
    void updateFilm(Film film);
    void deleteFilm(Long id);
    List<Film> getAllFilms();
    Film getFilmById(Long id);

}
