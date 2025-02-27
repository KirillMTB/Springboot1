package ru.example.version2.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.example.version2.entities.Director;
import ru.example.version2.services.DirectorService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/directors")
public class DirectorController {
    @Autowired
    protected DirectorService directorService;

    @GetMapping//("/director") //
    @ResponseBody
    public List<Director> getDirector(){//метод возвращающий тест в качестве хттп ответа
        return directorService.getDirectors();
    }
    @GetMapping("/{directorId}")
    public Director getDirectorId(@PathVariable("directorId") UUID id){ //для поиска по айдишнику
        System.out.println(id);
        return directorService.getDirectorById(id);//Director.builder().build();
    }
    @DeleteMapping("/{directorId}")//("/director") //
    public Boolean deleteDirector(@PathVariable("directorId")UUID id){//метод возвращающий тест в качестве хттп ответа
        try{directorService.deleteById(id);
            System.out.println("Delete");
            return true;}
        catch(Exception e) {return false;}

    }

    @PutMapping//("/director") //
    public Director editDirector(@RequestBody Director director){//метод возвращающий тест в качестве http ответа
        System.out.println("Edit");
        return directorService.editDirector(director);
    }

    @PostMapping//("/director") //
    public Director saveDirector(@RequestBody Director director){
        return directorService.addDirector(director);
    }
}
