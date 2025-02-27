package ru.example.version2.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.example.version2.entities.Movie;
import ru.example.version2.services.MovieService;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/movie") //либо так, либо гетмаппингом
public class MovieController {

    @Autowired
    protected MovieService movieService;
    @GetMapping//("/movie") //
    @ResponseBody
    public List<Movie> getMovies(){//метод возвращающий тест в качестве http ответа
        return movieService.getMovies();
    }
    @GetMapping("/{movieId}")
    public Movie getMovieId(@PathVariable("movieId")UUID id){ //для поиска по айдишнику
        System.out.println(id);
        return movieService.getMovieById(id);//Movie.builder().build();
    }
    @DeleteMapping("/{movieId}")//("/movie") //
    public Boolean deleteMovie(@PathVariable("movieId")UUID id){//метод возвращающий тест в качестве http ответа
        try{movieService.deleteById(id);
        System.out.println("Delete");
        return true;}
        catch(Exception e) {return false;}

    }

    @PutMapping//("/movie") //
    public Movie editMovie(@RequestBody Movie movie){//метод возвращающий тест в качестве http ответа
        System.out.println("Edit");
        return movieService.editMovie(movie);
    }

   @PostMapping//("/movie") //
   public Movie saveMovie(@RequestBody Movie movie){
       return movieService.addMovie(movie);
   }
}
