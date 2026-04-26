package org.example.springboottest2.SS14.DTO;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class EmployeeCreateDTO {

    private String fullName;
    private String email;
    private String department;
    private MultipartFile avatarFile;

}