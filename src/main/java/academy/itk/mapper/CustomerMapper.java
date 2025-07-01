package academy.itk.mapper;

import academy.itk.model.Customer;
import academy.itk.model.dto.CustomerDto;
import academy.itk.model.dto.CustomerPost;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    Customer maptoToCustomer(CustomerPost customer);

    CustomerDto maptoToCustomerDto(Customer customer);
}
