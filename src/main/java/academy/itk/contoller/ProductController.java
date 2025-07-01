package academy.itk.contoller;

import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

public interface ProductController {

    ResponseEntity<String> getAllProducts() throws JsonProcessingException;

    ResponseEntity<String> getProductById(@Positive Long id) throws JsonProcessingException;

    ResponseEntity<String> createProduct(String productPostJson) throws JsonProcessingException;

    ResponseEntity<String> updateProduct(String productPostJson, @Positive Long id) throws JsonProcessingException;

    ResponseEntity<Void> deleteProduct(@Positive Long id);
}
