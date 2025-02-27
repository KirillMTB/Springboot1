package ru.example.version2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.example.version2.entities.Jenre;
import ru.example.version2.services.JenreService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/jenres")
public class JenreController {
    @Autowired
    protected JenreService jenreService;

    @GetMapping//("/jenre") //
    @ResponseBody
    public List<Jenre> getJenres(){//метод возвращающий тест в качестве хттп ответа
        return jenreService.getJenres();
    }
    @GetMapping("/{jenreId}")
    public Jenre getJenreId(@PathVariable("jenreId") UUID id){ //для поиска по айдишнику
        System.out.println(id);
        return jenreService.getJenreById(id);//Jenre.builder().build();
    }
    @DeleteMapping("/{jenreId}")//("/jenre") //
    public Boolean deleteJenre(@PathVariable("jenreId")UUID id){//метод возвращающий тест в качестве хттп ответа
        try{jenreService.deleteById(id);
            System.out.println("Delete");
            return true;}
        catch(Exception e) {return false;}

    }

    @PutMapping//("/jenre") //
    public Jenre editJenre(@RequestBody Jenre jenre){//метод возвращающий тест в качестве хттп ответа
        System.out.println("Edit");
        return jenreService.editJenre(jenre);
    }

    @PostMapping//("/jenre") //
    public Jenre saveJenre(@RequestBody Jenre jenre){
        return jenreService.addJenre(jenre);
    }
}
