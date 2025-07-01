package academy.itk.model.dto;

import lombok.Data;

@Data
public class CustomerDto {
    private long id;
    private String name;
    private String email;
    private String phone;
}
