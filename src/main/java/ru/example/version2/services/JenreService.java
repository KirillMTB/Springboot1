package ru.example.version2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.version2.entities.Jenre;
import ru.example.version2.repositories.JenreRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class JenreService {
    @Autowired
    protected JenreRepository jenreRepository;

    public Jenre getJenreById(UUID id){
        Optional<Jenre> jenre= jenreRepository.findById(id);
        if (jenre.isEmpty()){
            throw new RuntimeException("Жанра фильма с таким ID не существует");
        }
        return jenre.get();
    }
    public List<Jenre> getJenres(){
        return jenreRepository.findAll(); //jenres;
    }
    public Jenre addJenre(Jenre jenre){
        return jenreRepository.save(jenre);


    }

    public Jenre editJenre(Jenre jenre){
        return jenreRepository.save(jenre);


    }

    public void deleteById(UUID id){
        jenreRepository.deleteById(id);
    }
}
