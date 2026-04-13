package org.example.springboottest2.SS8.Controller;


import jakarta.validation.Valid;
import org.example.springboottest2.SS8.DTO.Reponse.ApiResponse2;
import org.example.springboottest2.SS8.DTO.Request.BorrowCreateDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {



    @PostMapping
    public String borrow(@Valid @RequestBody BorrowCreateDTO borrowCreateDTO) {

        System.out.println("Borrow: " + borrowCreateDTO);

        System.out.println("Xử lí trong controller");

        return "thanh cong";
    }
}
