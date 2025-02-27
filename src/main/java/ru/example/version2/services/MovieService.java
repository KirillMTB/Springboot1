package ru.example.version2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.version2.entities.Movie;
import ru.example.version2.repositories.MovieRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class MovieService {

    @Autowired
    protected MovieRepository movieRepository;

    public Movie getMovieById(UUID id){
        Optional<Movie> movie= movieRepository.findById(id);
        if (movie.isEmpty()){
            throw new RuntimeException("Фильма с таким ID не существует");
        }
        return movie.get();
    }
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }
    public Movie addMovie(Movie movie){
       return movieRepository.save(movie);


    }

    public Movie editMovie(Movie movie){
        return movieRepository.save(movie);


    }

    public void deleteById(UUID id){
        movieRepository.deleteById(id);
    }

}
