package com.example.demo.controller;

import com.example.demo.model.Film;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.service.FilmServiceImpl;
import com.example.demo.service.UserServiceImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
public class UserRestController {

    private final FilmServiceImpl filmServiceImpl;
    private final UserServiceImpl userServiceImpl;

    public UserRestController(FilmServiceImpl filmServiceImpl, UserServiceImpl userServiceImpl) {
        this.filmServiceImpl = filmServiceImpl;
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/roles")
    public String getRole() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Set<Role> roles = user.getRoles();
        if(roles.contains(Role.ADMIN)) {
            return "admin";
        } else {
            return "user";
        }
    }

    @GetMapping("/getAllFilms")
    public List<Film> getListFilms() {
        return filmServiceImpl.getAllFilms();
    }

    @PutMapping("/addLikesFilms/{filmId}")
    public void addToLikesFilms(@PathVariable String filmId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Film film = filmServiceImpl.getFilmById(Long.parseLong(filmId));
        userServiceImpl.addToLikesFilms(user, film);
    }

    @GetMapping("/getLikesFilms")
    public Set<Film> getLikesFilms() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userServiceImpl.getLikesFilms(user);
    }

    @DeleteMapping("/deleteLikeFilm/{filmId}")
    public void deleteLikeFilm(@PathVariable String filmId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Film film = filmServiceImpl.getFilmById(Long.parseLong(filmId));
        userServiceImpl.deleteLikeFilm(user, film);
    }



}
