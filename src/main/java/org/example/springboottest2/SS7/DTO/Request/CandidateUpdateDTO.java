package org.example.springboottest2.SS7.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CandidateUpdateDTO {

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    @Size(max = 200, message = "Bio tối đa 200 ký tự")
    private String bio;
}