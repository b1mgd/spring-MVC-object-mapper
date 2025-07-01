package academy.itk.contoller;

import academy.itk.model.dto.OrderDto;
import academy.itk.model.dto.OrderPost;
import academy.itk.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@Validated
public class OrderControllerImpl implements OrderController {
    private final OrderService orderService;
    private final ObjectMapper objectMapper;

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getOrderById(@PathVariable Long id) throws JsonProcessingException {
        OrderDto order = orderService.getOrderById(id);
        String json = objectMapper.writeValueAsString(order);
        return ResponseEntity.ok(json);
    }

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createOrder(@RequestBody String orderPostJson) throws JsonProcessingException {
        OrderPost orderPost = objectMapper.readValue(orderPostJson, OrderPost.class);
        OrderDto orderDto = orderService.createOrder(orderPost);
        String json = objectMapper.writeValueAsString(orderDto);
        return ResponseEntity.ok(json);
    }
}
