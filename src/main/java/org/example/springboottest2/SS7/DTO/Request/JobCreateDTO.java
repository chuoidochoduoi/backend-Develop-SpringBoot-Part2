package org.example.springboottest2.SS7.DTO.Request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class JobCreateDTO {

    @NotBlank(message = "Title must not be blank")
    private String title;

    @NotNull(message = "Company must not be null")
    @Valid
    private CompanyDTO company;
}
