package academy.itk.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {
    private long id;
    private String name;
    private String description;
    private BigDecimal price;
    private long quantity;
}
