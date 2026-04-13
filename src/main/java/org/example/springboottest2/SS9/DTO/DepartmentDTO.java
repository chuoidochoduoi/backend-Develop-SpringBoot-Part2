package org.example.springboottest2.SS9.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class DepartmentDTO {

    @NotBlank
    @Size(min = 5, max = 50, message = "Tên phòng ban phải từ 5-50 ký tự")
    String name;
    @Size(max = 100, message = "phải nhỏ hơn 100")
    String description;
}
