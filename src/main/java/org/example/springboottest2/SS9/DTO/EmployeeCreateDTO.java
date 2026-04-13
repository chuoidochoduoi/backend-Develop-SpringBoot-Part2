package org.example.springboottest2.SS9.DTO;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmployeeCreateDTO {


    @NotNull(message = "ko null")
    String fullName;
    @Email(message = "Phải đúng định dạng")
    String email;
    @Pattern(
            regexp = "^(03|05|07|08|09)[0-9]{8}$",
            message = "Số điện thoại không hợp lệ"
    )
    String phone;
    @Min(value = 5000000, message = "ít  nhât là 5000000")
    double salary;
    @NotNull(message = "có tồn tai")
    Long departmentId;
}
