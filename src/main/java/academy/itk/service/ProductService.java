package academy.itk.service;

import academy.itk.model.dto.ProductDto;
import academy.itk.model.dto.ProductPost;

import java.util.List;

public interface ProductService {

    List<ProductDto> getAllProducts();

    ProductDto getProductById(Long id);

    ProductDto createProduct(ProductPost productPost);

    ProductDto updateProduct(ProductPost productPost, Long id);

    void deleteProduct(Long id);
}
