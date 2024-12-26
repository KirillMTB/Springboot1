package ru.example.version2.entities;
import jakarta.persistence.*;
//import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.security.cert.CertPathBuilder;
import java.util.List;
import java.util.UUID;


@Getter
@Setter
//@Builder
@ToString
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)//автоматически генерирует ключ перед сохранением в БД
    private UUID id;
    private String title;
    @ManyToMany
    private List<Author> authors;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @Column(name="publish_year")
    private Integer year;



}
