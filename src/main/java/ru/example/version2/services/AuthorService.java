package ru.example.version2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.version2.entities.Author;
import ru.example.version2.repositories.AuthorRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorService {
    @Autowired
    protected AuthorRepository authorRepository;

    public Author getAuthorById(UUID id){
        Optional<Author> author= authorRepository.findById(id);
        if (author.isEmpty()){
            throw new RuntimeException("Автора с таким ID не существует");
        }
        return author.get();
    }
    public List<Author> getAuthors(){
        return authorRepository.findAll(); //authors;
    }
    public Author addAuthor(Author author){
        return authorRepository.save(author);
        // data.add(author);

    }

    public Author editAuthor(Author author){
        return authorRepository.save(author);
        // data.add(author);

    }

    public void deleteById(UUID id){
        authorRepository.deleteById(id);
    }
}
