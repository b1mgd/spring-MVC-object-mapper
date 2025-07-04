package academy.itk.service;

import academy.itk.exception.NotFoundException;
import academy.itk.mapper.OrderMapper;
import academy.itk.model.Customer;
import academy.itk.model.Order;
import academy.itk.model.dto.OrderDto;
import academy.itk.model.dto.OrderPost;
import academy.itk.repository.CustomerRepository;
import academy.itk.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Нужно реализовать обновление поля cost в заказах.
 * 1) Передавать объекты с price вместе с заказом - проводить сумму по ним
 * 2) Добавлять пустой заказ. Потом вызывать метод пересчета значений сost
 */
@Service
@RequiredArgsConstructor
@Transactional
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    private final CustomerRepository customerRepository;

    @Override
    @Transactional(readOnly = true)
    public OrderDto getOrderById(Long id) {
        return orderMapper.mapToOrderDto(getOrder(id));
    }

    @Override
    public OrderDto createOrder(OrderPost orderPost) {
        long customerId = orderPost.getCustomerId();
        Customer customer = getCustomer(customerId);
        BigDecimal initialCost = orderPost.getCost();

        Order order = orderMapper.mapToOrder(orderPost, customer, initialCost);
        findCost(order);
        Order savedOrder = orderRepository.save(order);

        return orderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::mapToOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto updateOrder(OrderPost orderPost, Long id) {
        Order order = getOrder(id);
        // Обновляем только поля, которые приходят в orderPost
        order.setAddress(orderPost.getAddress());
        order.setCost(orderPost.getCost());
        order.setStatus(orderPost.getStatus());
        // customerId и продукты не обновляем для простоты
        Order updatedOrder = orderRepository.save(order);
        return orderMapper.mapToOrderDto(updatedOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

    private Order getOrder(long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Заказ с id: %d не найден", id)));
    }

    private Customer getCustomer(long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Клиент с id: %d не найден", id)));
    }

    private void findCost(Order order) {
        BigDecimal total = order.getProducts().stream()
                .map(item -> item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setCost(total);
    }
}
