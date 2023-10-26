package api_test.demo.service;

import api_test.demo.entity.Category;
import api_test.demo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> readAll(){
        return categoryRepository.findAll();
    }

    public Category readById(Long id){
        return categoryRepository.findById(id).orElseThrow(()->
                new RuntimeException("Category tapılmadı " + id));
    }
}
