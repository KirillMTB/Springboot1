package ru.example.version2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.version2.entities.Jenre;

import java.util.UUID;
@Repository
public interface JenreRepository extends JpaRepository<Jenre, UUID> {
}
