package com.example.demo.service;

import com.example.demo.DAO.FilmDAO;
import com.example.demo.DAO.UserDAO;
import com.example.demo.model.Film;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class FilmServiceImpl implements FilmService {

    private final FilmDAO filmDAO;
    private final UserDAO userDAO;

    @Autowired
    public FilmServiceImpl(FilmDAO filmDAO, UserDAO userDAO) {
        this.filmDAO = filmDAO;
        this.userDAO = userDAO;
    }

    @Override
    public void addFilm(Film film) {
        if (filmDAO.findFilmByTitle(film.getTitle()) == null)  {
            filmDAO.save(film);
        }
    }

    @Override
    public void updateFilm(Film updateFilm) {
        Film film = getFilmById(updateFilm.getId());
        film.setTitle(updateFilm.getTitle());
        filmDAO.save(film);
    }

    @Override
    public void deleteFilm(Long id) {
        filmDAO.deleteById(id);
    }

    @Override
    public List<Film> getAllFilms() {
        return filmDAO.findAll();
    }

    @Override
    public Film getFilmById(Long id) {
        return filmDAO.findById(id).get();
    }
}
