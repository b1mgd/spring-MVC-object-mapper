package academy.itk.mapper;

import academy.itk.model.Customer;
import academy.itk.model.Order;
import academy.itk.model.dto.OrderDto;
import academy.itk.model.dto.OrderPost;
import org.mapstruct.*;

import java.math.BigDecimal;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface OrderMapper {

    Order mapToOrder(OrderPost orderPost, @Context Customer customer, @Context BigDecimal cost);

    @AfterMapping
    default void setCustomerAndCost(OrderPost orderPost,
                                    @MappingTarget Order order,
                                    @Context Customer customer,
                                    @Context BigDecimal cost) {
        order.setCustomer(customer);
        order.setCost(cost);
    }

    @Mapping(source = "customer.id", target = "customerId")
    OrderDto mapToOrderDto(Order order);
}
