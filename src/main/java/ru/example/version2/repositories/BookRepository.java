package ru.example.version2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.example.version2.entities.Book;
import ru.example.version2.entities.Category;

import java.util.UUID;
@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    @Query(value = "SELECT COUNT (b) FROM Book b WHERE b.category.id = :categoryId")
    int countBooksByCategory(@Param("categoryId")UUID categoryID);
}
