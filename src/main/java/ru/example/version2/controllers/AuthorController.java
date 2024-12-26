package ru.example.version2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.example.version2.entities.Author;
import ru.example.version2.services.AuthorService;
import ru.example.version2.services.AuthorService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    protected AuthorService authorService;

    @GetMapping//("/author") //
    @ResponseBody
    public List<Author> getAuthor(){//метод возвращающий тест в качестве хттп ответа
        return authorService.getAuthors();
    }
    @GetMapping("/{authorId}")
    public Author getAuthorId(@PathVariable("authorId") UUID id){ //для поиска по айдишнику
        System.out.println(id);
        return authorService.getAuthorById(id);//Author.builder().build();
    }
    @DeleteMapping("/{authorId}")//("/author") //
    public Boolean deleteAuthor(@PathVariable("authorId")UUID id){//метод возвращающий тест в качестве хттп ответа
        try{authorService.deleteById(id);
            System.out.println("Delete");
            return true;}
        catch(Exception e) {return false;}

    }

    @PutMapping//("/author") //
    public Author editAuthor(@RequestBody Author author){//метод возвращающий тест в качестве хттп ответа
        System.out.println("Edit");
        return authorService.editAuthor(author);
    }

    @PostMapping//("/author") //
    public Author saveAuthor(@RequestBody Author author){
        return authorService.addAuthor(author);
    }
}
