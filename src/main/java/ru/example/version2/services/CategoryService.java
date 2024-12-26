package ru.example.version2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.version2.entities.Category;
import ru.example.version2.repositories.CategoryRepository;
import ru.example.version2.repositories.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    protected CategoryRepository categoryRepository;

    public Category getCategoryById(UUID id){
        Optional<Category> category= categoryRepository.findById(id);
        if (category.isEmpty()){
            throw new RuntimeException("Киниги с таким ID не существует");
        }
        return category.get();
    }
    public List<Category> getCategorys(){

        return categoryRepository.findAll(); //categorys;
    }
    public Category addCategory(Category category){
        return categoryRepository.save(category);
        // data.add(category);

    }

    public Category editCategory(Category category){
        return categoryRepository.save(category);
        // data.add(category);

    }

    public void deleteById(UUID id){
        categoryRepository.deleteById(id);
    }
}
