package org.example.springboottest2.SS8.Service;


import org.example.springboottest2.SS8.DTO.Request.BookCreateDTO;
import org.example.springboottest2.SS8.DTO.Request.BookUpdateStockDTO;
import org.example.springboottest2.SS8.Repository.BookRepository;
import org.example.springboottest2.SS8.exception.ResourceNotFoundException;
import org.example.springboottest2.SS8.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class BookService {


    private static final String UPLOAD_DIR =   "D:/sas/";


    @Autowired
    BookRepository bookRepository;

    public Book createBook(BookCreateDTO bookCreateDTO) throws IOException {

        Book book = new Book();
        book.setAuthor(bookCreateDTO.getAuthor());
        book.setTitle(bookCreateDTO.getTitle());
        book.setStock(bookCreateDTO.getStock());



       String fileUrl= setUploadFile(bookCreateDTO.getCoverImage());

        book.setCoverUrl(fileUrl);

        bookRepository.save(book);


        return book;
    }





    public String setUploadFile(MultipartFile file) throws IOException {


        String fileName = UUID.randomUUID().toString() + ".jpg";

        File destinationFile = new File(UPLOAD_DIR+fileName);


        if (!destinationFile.getParentFile().exists()) {
            destinationFile.getParentFile().mkdirs();
        }

        file.transferTo(destinationFile);


        return destinationFile.getAbsolutePath();
    }


    public void updateBook(Long id, BookUpdateStockDTO dto) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with " + id));

   book.setStock(dto.getStock());


        bookRepository.save(book);
    }

    public Book getBook(Long id) {

        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with " + id));
    }
}
