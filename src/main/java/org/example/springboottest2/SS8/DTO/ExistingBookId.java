package org.example.springboottest2.SS8.DTO;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.example.springboottest2.SS8.Validator.BookIdValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = BookIdValidator.class) // cái này chỉ định class nào để check
@Target({ElementType.FIELD}) // dành cho trường thuộc tính
@Retention(RetentionPolicy.RUNTIME) // cái này là quy định lúc nào nó chạy
public @interface ExistingBookId {


    String message() default "không tồn tại";
    Class<?>[] groups() default {}; // hệ thống yêu cầu nhưng rất ít dùng cả cái dưới
    Class<? extends Payload>[] payload() default {};
}