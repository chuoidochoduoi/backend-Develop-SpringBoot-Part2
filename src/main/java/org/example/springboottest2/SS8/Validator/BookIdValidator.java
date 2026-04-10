package org.example.springboottest2.SS8.Validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.springboottest2.SS8.DTO.ExistingBookId;
import org.example.springboottest2.SS8.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookIdValidator implements ConstraintValidator<ExistingBookId, Long> {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public boolean isValid(Long bookId, ConstraintValidatorContext context) {
        if (bookId == null) {
            return false;
        }

        return bookRepository.existsById(bookId);
    }
}