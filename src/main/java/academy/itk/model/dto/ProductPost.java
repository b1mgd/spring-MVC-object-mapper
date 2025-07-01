package academy.itk.model.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductPost {

    @NotBlank
    @Size(min = 2, max = 50)
    private String name;

    @Size(max = 1000)
    private String description;

    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal price;

    @Positive
    private long quantity;
}
