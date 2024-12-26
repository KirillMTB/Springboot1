package ru.example.version2.entities;
import jakarta.persistence.*;
//import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
//@Builder
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)//автоматически генерирует ключ перед сохранением в БД
    private UUID id;
    private String name;

    //@OneToMany можно или так или как в Букс
    //private List<Book> books;
}

