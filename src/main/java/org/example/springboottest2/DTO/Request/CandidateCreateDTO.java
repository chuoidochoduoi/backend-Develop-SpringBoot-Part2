package org.example.springboottest2.DTO.Request;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CandidateCreateDTO {

    @NotBlank(message = "Tên không được để trống")
    @Size(min = 5, max = 50, message = "Tên phải từ 5-50 ký tự")
    String fullName;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    String email;

    @Min(value = 18, message = "Tuổi phải >= 18")
    int age;

    @Min(value = 0, message = "Kinh nghiệm phải >= 0")
    int yearsOfExperience;

    @Pattern(
            regexp = "^(03|05|07|08|09)[0-9]{8}$",
            message = "Số điện thoại không hợp lệ"
    )
    String phone;
}
