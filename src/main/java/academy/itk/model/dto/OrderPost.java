package academy.itk.model.dto;

import academy.itk.model.Status;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderPost {

    @NotBlank
    @Size(max = 1000)
    private String address;

    @NotNull
    @DecimalMin(value = "0.00")
    private BigDecimal cost;

    private Status status;

    @Positive
    private Long customerId;
}
