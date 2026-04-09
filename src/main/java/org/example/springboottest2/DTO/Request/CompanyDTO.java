package org.example.springboottest2.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CompanyDTO {

    @NotBlank(message = "company name must not be blank")
    private String name;

    @Size(min = 10, max = 13, message = "  between 10 and 13 char")
    private String taxCode;

}
