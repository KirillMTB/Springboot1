package ru.example.version2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.example.version2.entities.Movie;

import java.util.UUID;
@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {
    @Query(value = "SELECT COUNT (b) FROM Movie b WHERE b.director.id = :directorId")
    int countMoviesByDirector(@Param("directorId")UUID directorID);
}
