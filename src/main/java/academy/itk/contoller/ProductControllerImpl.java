package academy.itk.contoller;

import academy.itk.model.dto.ProductDto;
import academy.itk.model.dto.ProductPost;
import academy.itk.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Validated
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;

    @Override
    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @Override
    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @Override
    @PostMapping
    public ProductDto createProduct(@RequestBody ProductPost productPost) {
        return productService.createProduct(productPost);
    }

    @Override
    @PatchMapping("/{id}")
    public ProductDto updateProduct(@RequestBody ProductPost productPost,
                                    @PathVariable Long id) {
        return productService.updateProduct(productPost, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
