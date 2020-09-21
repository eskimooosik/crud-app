package com.example.demo.service;

import com.example.demo.DAO.FilmDAO;
import com.example.demo.DAO.UserDAO;
import com.example.demo.model.Film;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final FilmDAO filmDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO, FilmDAO filmDAO) {
        this.userDAO = userDAO;
        this.filmDAO = filmDAO;
    }

    @Override
    public void addUser(User user) {
        User newUser = user;
        Set<Role> role = new HashSet<>();
        role.add(Role.USER);
        role.add(Role.ADMIN);
        newUser.setActive(true);
        newUser.setRoles(role);
        userDAO.save(newUser);
    }

    @Override
    public User findUserByEmail(String email) {
        return userDAO.findUserByEmail(email);
    }

    @Override
    public void addToLikesFilms(User user, Film film) {
          user.getFilms().add(film);
          film.getUserLikes().add(user);
          userDAO.save(user);
          filmDAO.save(film);
       }

    @Override
    public Set<Film> getLikesFilms(User user) {
        return user.getFilms();
    }

    @Override
    public void deleteLikeFilm(User user, Film film) {
        film.getUserLikes().remove(user);
        user.getFilms().remove(film);
        userDAO.save(user);
        filmDAO.save(film);
        }
}
