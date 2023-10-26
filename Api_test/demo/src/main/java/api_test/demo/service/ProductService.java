package api_test.demo.service;

import api_test.demo.DTO.ProductDto;
import api_test.demo.entity.Product;
import api_test.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public Product create (ProductDto dto){
        return productRepository.save(Product.builder()
                .name(dto.getName())
                .amount(dto.getAmount())
                        .category(categoryService.readById(dto.getCategoryId()))
                .build());
    }
    public List<Product> readAll(){
        return productRepository.findAll();
    }

    public List<Product> readByCategoryId(Long id){
        return productRepository.findByCategoryId(id);
    }

    public Product update(Product product){
        return productRepository.save(product);
    }

    public void delete(Long id){
        productRepository.deleteById(id);
    }

}
