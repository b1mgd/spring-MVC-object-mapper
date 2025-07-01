package academy.itk.contoller;

import academy.itk.model.dto.ProductDto;
import academy.itk.model.dto.ProductPost;
import academy.itk.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Validated
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;
    private final ObjectMapper objectMapper;

    @Override
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllProducts() throws JsonProcessingException {
        List<ProductDto> products = productService.getAllProducts();
        String json = objectMapper.writeValueAsString(products);
        return ResponseEntity.ok(json);
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getProductById(@PathVariable Long id) throws JsonProcessingException {
        ProductDto product = productService.getProductById(id);
        String json = objectMapper.writeValueAsString(product);
        return ResponseEntity.ok(json);
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createProduct(@RequestBody String productPostJson) throws JsonProcessingException {
        ProductPost productPost = objectMapper.readValue(productPostJson, ProductPost.class);
        ProductDto productDto = productService.createProduct(productPost);
        String json = objectMapper.writeValueAsString(productDto);
        return ResponseEntity.ok(json);
    }

    @Override
    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateProduct(@RequestBody String productPostJson, @PathVariable Long id) throws JsonProcessingException {
        ProductPost productPost = objectMapper.readValue(productPostJson, ProductPost.class);
        ProductDto productDto = productService.updateProduct(productPost, id);
        String json = objectMapper.writeValueAsString(productDto);
        return ResponseEntity.ok(json);
    }

    @Override
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);

        return ResponseEntity.noContent().build();
    }
}
