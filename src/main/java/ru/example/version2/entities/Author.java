package ru.example.version2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
//@Builder
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)//автоматически генерирует ключ перед сохранением в БД
    private UUID id;
    private  String fullname;

}
