package org.example.springboottest2.SS14.Controller;

import org.example.springboottest2.SS14.DTO.EmployeeCreateDTO;
import org.example.springboottest2.SS14.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v14/employees")
public class EmployeeController {

    @PostMapping
    public ResponseEntity<?> createEmployee(
            @ModelAttribute EmployeeCreateDTO dto
    )  {

        String avatarUrl = "https://fake-cloudinary.com/" + dto.getAvatarFile().getOriginalFilename();

        Employee emp = new Employee();
        emp.setFullName(dto.getFullName());
        emp.setEmail(dto.getEmail());
        emp.setDepartment(dto.getDepartment());
        emp.setAvatarUrl(avatarUrl);
        return ResponseEntity.ok(emp);
    }
}