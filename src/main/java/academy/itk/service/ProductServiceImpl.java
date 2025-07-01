package academy.itk.service;

import academy.itk.exception.NotFoundException;
import academy.itk.mapper.ProductMapper;
import academy.itk.model.Product;
import academy.itk.model.dto.ProductDto;
import academy.itk.model.dto.ProductPost;
import academy.itk.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::mapToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto getProductById(Long id) {
        return productMapper.mapToProductDto(getProduct(id));
    }

    @Override
    public ProductDto createProduct(ProductPost productPost) {
        Product product = productMapper.mapToProduct(productPost);
        Product savedProduct = productRepository.save(product);

        return productMapper.mapToProductDto(savedProduct);
    }

    @Override
    public ProductDto updateProduct(ProductPost productPost, Long id) {
        productExists(id);
        Product product = productMapper.mapToProduct(productPost);
        Product updatedProduct = productRepository.save(product);

        return productMapper.mapToProductDto(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productExists(id);
        productRepository.deleteById(id);
    }

    private Product getProduct(long id) {
        return productRepository.findById(id).
                orElseThrow(() -> new NotFoundException(String.format("Товар с id: %d не найден", id)));
    }

    private void productExists(long id) {
        boolean exists = productRepository.existsById(id);

        if (!exists) {
            throw new NotFoundException(String.format("Товар с id: %d не найден", id));
        }
    }
}
