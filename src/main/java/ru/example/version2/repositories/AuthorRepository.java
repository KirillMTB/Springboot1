package ru.example.version2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.version2.entities.Author;
import ru.example.version2.entities.Category;

import java.util.UUID;
@Repository
public interface AuthorRepository extends JpaRepository<Author, UUID> {
}