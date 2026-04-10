package org.example.springboottest2.SS8.DTO.Request;

import jakarta.validation.constraints.Min;
import lombok.Data;


@Data
public class BookUpdateStockDTO {

    @Min(0)
    int stock;
}
