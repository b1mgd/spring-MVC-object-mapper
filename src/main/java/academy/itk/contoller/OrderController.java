package academy.itk.contoller;

import academy.itk.model.dto.OrderDto;
import academy.itk.model.dto.OrderPost;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

public interface OrderController {

    OrderDto getOrderById(@Positive Long id);

    OrderDto createOrder(@Valid OrderPost order);
}
