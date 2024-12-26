package ru.example.version2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.version2.entities.Author;
import ru.example.version2.entities.Book;
import ru.example.version2.entities.Category;
import ru.example.version2.repositories.AuthorRepository;
import ru.example.version2.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service

public class BookService {
    //List<Book> data = new ArrayList<>();
    @Autowired
    protected BookRepository bookRepository;

    public Book getBookById(UUID id){
        Optional<Book> book= bookRepository.findById(id);
        if (book.isEmpty()){
            throw new RuntimeException("Киниги с таким ID не существует");
        }
        return book.get();
    }
    public List<Book> getBooks(){
        //List<Book> books = new ArrayList<>();
        //List<Author> authors = new ArrayList<>();


        /*Author author = Author.builder()
                .id(UUID.randomUUID())
                .fullname("Лев Николаевич Толстой")
                .build();

        authors.add(author);

        Book book = Book.builder()
                .id(UUID.randomUUID())
                .title("Война и мир")
                .year(1886)
                .category(Category.builder()
                        .id(UUID.randomUUID())
                        .name("Классическая литература")
                        .build())
                .authors(authors)
                .build();
        books.add(book);*/
        return bookRepository.findAll(); //books;
    }
    public Book addBook(Book book){
       return bookRepository.save(book);
        // data.add(book);

    }

    public Book editBook(Book book){
        return bookRepository.save(book);
        // data.add(book);

    }

    public void deleteById(UUID id){
        bookRepository.deleteById(id);
    }

}
