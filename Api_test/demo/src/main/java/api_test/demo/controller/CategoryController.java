package api_test.demo.controller;

import api_test.demo.entity.Category;
import api_test.demo.service.CategoryService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {

    private final CategoryService  categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> readAll(){
            return new ResponseEntity<>(categoryService.readAll(), HttpStatus.OK);
    }
}
