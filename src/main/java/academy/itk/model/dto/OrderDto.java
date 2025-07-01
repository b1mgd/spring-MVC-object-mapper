package academy.itk.model.dto;

import academy.itk.model.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDto {
    private long id;
    private String address;
    private BigDecimal cost;
    private Status status;
    private List<ProductDto> products = new ArrayList<>();
    private Long customerId;
}
