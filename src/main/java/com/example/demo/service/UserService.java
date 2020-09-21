package com.example.demo.service;

import com.example.demo.model.Film;
import com.example.demo.model.User;

import java.util.Set;

public interface UserService {
    void addUser(User user);
    User findUserByEmail(String email);
    void addToLikesFilms(User user, Film film);
    Set<Film> getLikesFilms(User user);
    void deleteLikeFilm(User user, Film film);
}
