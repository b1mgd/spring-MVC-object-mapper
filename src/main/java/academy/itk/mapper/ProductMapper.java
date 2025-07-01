package academy.itk.mapper;

import academy.itk.model.Product;
import academy.itk.model.dto.ProductDto;
import academy.itk.model.dto.ProductPost;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product mapToProduct(ProductPost productPost);

    ProductDto mapToProductDto(Product product);
}
