package com.example.demo.DAO;

import com.example.demo.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmDAO extends JpaRepository<Film, Long> {
    Film findFilmByTitle(String title);
}
