package ru.example.version2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.version2.entities.Director;
import ru.example.version2.repositories.DirectorRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DirectorService {
    @Autowired
    protected DirectorRepository directorRepository;

    public Director getDirectorById(UUID id){
        Optional<Director> director= directorRepository.findById(id);
        if (director.isEmpty()){
            throw new RuntimeException("Режиссера с таким ID не существует");
        }
        return director.get();
    }
    public List<Director> getDirectors(){

        return directorRepository.findAll(); //directors;
    }
    public Director addDirector(Director director){
        return directorRepository.save(director);
        // data.add(director);

    }

    public Director editDirector(Director director){
        return directorRepository.save(director);
        // data.add(director);

    }

    public void deleteById(UUID id){
        directorRepository.deleteById(id);
    }
}
