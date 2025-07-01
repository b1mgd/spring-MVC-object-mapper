package academy.itk.contoller;

import academy.itk.model.dto.ProductDto;
import academy.itk.model.dto.ProductPost;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

import java.util.List;

public interface ProductController {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(@Positive Long id);

    ProductDto createProduct(@Valid ProductPost productPost);

    ProductDto updateProduct(@Valid ProductPost productPost, @Positive Long id);

    void deleteProduct(@Positive Long id);
}
