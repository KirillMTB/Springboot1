package ru.example.version2.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@ToString
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)//автоматически генерирует ключ перед сохранением в БД
    private UUID id;
    private String title;
    @ManyToMany
    private List<Jenre> jenres;
    @ManyToOne
    @JoinColumn(name="director_id")
    private Director director;
    @Column(name="publish_year")
    private Integer year;



}
