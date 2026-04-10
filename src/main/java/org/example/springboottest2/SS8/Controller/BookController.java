package org.example.springboottest2.SS8.Controller;

import jakarta.validation.Valid;
import org.example.springboottest2.SS8.DTO.Reponse.ApiResponse2;
import org.example.springboottest2.SS8.DTO.Request.BookCreateDTO;
import org.example.springboottest2.SS8.DTO.Request.BookUpdateStockDTO;
import org.example.springboottest2.SS8.Service.BookService;
import org.example.springboottest2.SS8.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/book")
public class BookController {


    @Autowired
    BookService bookService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse2<Book>> getBook( @PathVariable("id") long id)   {

      Book book =  bookService.getBook(id);

        return ResponseEntity.status(200).body(ApiResponse2.ok(book));
    }

    @PostMapping()
    public ResponseEntity<ApiResponse2<Book>> createBook(@ModelAttribute BookCreateDTO bookCreateDTO) throws IOException {


        Book book = bookService.createBook(bookCreateDTO);


        return ResponseEntity.status(201).body(ApiResponse2.ok(book));


    }


    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse2<Void>> updateBook( @PathVariable("id") long id,@Valid @RequestBody BookUpdateStockDTO bookUpdateStockDTO)   {

        bookService.updateBook(id, bookUpdateStockDTO);



        return ResponseEntity.status(200).body(ApiResponse2.ok(null));
    }
}
