package org.example.springboottest2.SS8.DTO.Request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;


@Data

public class BookCreateDTO {


    String title;
    String author;
    Integer stock;
    MultipartFile coverImage;
}
