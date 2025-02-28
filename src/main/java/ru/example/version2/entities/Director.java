package ru.example.version2.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@Entity

public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)//автоматически генерирует ключ перед сохранением в БД
    private UUID id;
    private String fullname;

}

