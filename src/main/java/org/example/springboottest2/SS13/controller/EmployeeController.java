package org.example.springboottest2.SS13.controller;


import org.example.springboottest2.SS13.model.Employee2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees13")
public class EmployeeController {

    @GetMapping
    public List<Employee2> getEmployees() {
        return Arrays.asList(
                new Employee2(1, "Nguyen Van A", 1000),
                new Employee2(2, "Tran Thi B", 2000),
                new Employee2(3, "Le Van C", 3000)
        );
    }
}
