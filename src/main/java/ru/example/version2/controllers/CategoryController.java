package ru.example.version2.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.example.version2.entities.Category;
import ru.example.version2.entities.Category;
import ru.example.version2.services.BookService;
import ru.example.version2.services.CategoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    protected CategoryService categoryService;

    @GetMapping//("/category") //
    @ResponseBody
    public List<Category> getCategory(){//метод возвращающий тест в качестве хттп ответа
        return categoryService.getCategorys();
    }
    @GetMapping("/{categoryId}")
    public Category getCategoryId(@PathVariable("categoryId") UUID id){ //для поиска по айдишнику
        System.out.println(id);
        return categoryService.getCategoryById(id);//Category.builder().build();
    }
    @DeleteMapping("/{categoryId}")//("/category") //
    public Boolean deleteCategory(@PathVariable("categoryId")UUID id){//метод возвращающий тест в качестве хттп ответа
        try{categoryService.deleteById(id);
            System.out.println("Delete");
            return true;}
        catch(Exception e) {return false;}

    }

    @PutMapping//("/category") //
    public Category editCategory(@RequestBody Category category){//метод возвращающий тест в качестве хттп ответа
        System.out.println("Edit");
        return categoryService.editCategory(category);
    }

    @PostMapping//("/category") //
    public Category saveCategory(@RequestBody Category category){
        return categoryService.addCategory(category);
    }
}
