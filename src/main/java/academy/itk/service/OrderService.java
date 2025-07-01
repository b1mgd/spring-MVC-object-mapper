package academy.itk.service;

import academy.itk.model.dto.OrderDto;
import academy.itk.model.dto.OrderPost;


public interface OrderService {
    OrderDto getOrderById(Long id);

    OrderDto createOrder(OrderPost order);
}
