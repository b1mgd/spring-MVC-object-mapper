package academy.itk.contoller;

import academy.itk.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Реализация не требуется по условию
 */
@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
@Validated
public class CustomerControllerImpl implements CustomerController {
    private final CustomerService customerService;
}
