package academy.itk.service;

import academy.itk.model.dto.OrderDto;
import academy.itk.model.dto.OrderPost;
import java.util.List;

public interface OrderService {
    OrderDto getOrderById(Long id);

    OrderDto createOrder(OrderPost order);

    List<OrderDto> getAllOrders();

    OrderDto updateOrder(OrderPost orderPost, Long id);

    void deleteOrder(Long id);
}
