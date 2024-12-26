package ru.example.version2.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.example.version2.entities.Author;
import ru.example.version2.entities.Book;
import ru.example.version2.entities.Category;
import ru.example.version2.services.BookService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/books") //либо так, либо гетмаппингом
public class BookController {

    @Autowired
    protected BookService bookService;
    @GetMapping//("/book") //
    @ResponseBody
    public List<Book> getBook(){//метод возвращающий тест в качестве хттп ответа
        return bookService.getBooks();
    }
    @GetMapping("/{bookId}")
    public Book getBookId(@PathVariable("bookId")UUID id){ //для поиска по айдишнику
        System.out.println(id);
        return bookService.getBookById(id);//Book.builder().build();
    }
    @DeleteMapping("/{bookId}")//("/book") //
    public Boolean deleteBook(@PathVariable("bookId")UUID id){//метод возвращающий тест в качестве хттп ответа
        try{bookService.deleteById(id);
        System.out.println("Delete");
        return true;}
        catch(Exception e) {return false;}

    }

    @PutMapping//("/book") //
    public Book editBook(@RequestBody Book book){//метод возвращающий тест в качестве хттп ответа
        System.out.println("Edit");
        return bookService.editBook(book);
    }

   /* @PostMapping//("/book") //
    public String saveBook(@RequestBody Book book,//@RequestBody тело запроса помещено в параметральную переменную
                           @RequestHeader("Content-Type") String contentType){
        //System.out.println(book);
        System.out.println(contentType);
        return "Test";
    }*/
   @PostMapping//("/book") //
   public Book saveBook(@RequestBody Book book){
       return bookService.addBook(book);
   }
}
