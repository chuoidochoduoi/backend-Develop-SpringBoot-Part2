package org.example.springboottest2.SS8.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.example.springboottest2.SS8.DTO.ExistingBookId;

@Data
public class BorrowCreateDTO {


    @NotBlank
    String username;
    @ExistingBookId
    Long bookId;
}

