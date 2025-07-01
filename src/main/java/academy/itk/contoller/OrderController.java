package academy.itk.contoller;

import jakarta.validation.constraints.Positive;
import org.springframework.http.ResponseEntity;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface OrderController {
    ResponseEntity<String> getOrderById(@Positive Long id) throws JsonProcessingException;

    ResponseEntity<String> createOrder(String orderPostJson) throws JsonProcessingException;
}
