package org.example.springboottest2.SS9.controller;

import jakarta.validation.Valid;
import org.example.springboottest2.SS9.DTO.ApiResponse;
import org.example.springboottest2.SS9.DTO.EmployeeCreateDTO;
import org.example.springboottest2.SS9.Service.EmployeeService;
import org.example.springboottest2.SS9.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> createEmployee(@Valid @RequestBody EmployeeCreateDTO employeeCreateDTO) {

        employeeService.AddEmployee(employeeCreateDTO);


        return ResponseEntity.ok().build();
    }
}
