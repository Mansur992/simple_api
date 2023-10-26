package api_test.demo.controller;

import api_test.demo.DTO.ProductDto;
import api_test.demo.entity.Product;
import api_test.demo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    private ResponseEntity<Product> create(@RequestBody ProductDto dto){
            return mappingResponseProduct(productService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Product>> readAll(){
        return mappingResponseListProduct(productService.readAll());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Product>> readByCategoryId(@PathVariable Long id){
        return mappingResponseListProduct(productService.readByCategoryId(id));
    }


    @PutMapping
    public ResponseEntity<Product>  update(@RequestBody Product product){
        return mappingResponseProduct(productService.update(product));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id){
            productService.delete(id);
            return HttpStatus.OK;
    }

    private ResponseEntity<Product> mappingResponseProduct(Product product){
            return new ResponseEntity<>(product,HttpStatus.OK);
    }

    private ResponseEntity<List<Product>> mappingResponseListProduct(List<Product> products){
            return new ResponseEntity<>(products,HttpStatus.OK);
    }
}
