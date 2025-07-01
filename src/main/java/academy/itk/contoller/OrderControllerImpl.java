package academy.itk.contoller;

import academy.itk.model.dto.OrderDto;
import academy.itk.model.dto.OrderPost;
import academy.itk.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Validated
public class OrderControllerImpl implements OrderController {
    private final OrderService orderService;

    @Override
    @GetMapping("/{id}")
    public OrderDto getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @Override
    @PostMapping
    public OrderDto createOrder(@RequestBody OrderPost orderPost) {
        return orderService.createOrder(orderPost);
    }
}
