//package org.example.springboottest2.SS9.controller;
//
//
//import jakarta.validation.Valid;
//import org.example.springboottest2.SS9.DTO.DepartmentDTO;
//import org.example.springboottest2.SS9.Service.DepartmentService;
//import org.example.springboottest2.SS9.model.Department;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/v1/departments")
//public class DepartmentController {
//
//    @Autowired
//DepartmentService departmentService;
//
//    @PostMapping
//    public ResponseEntity<Void> createDepartment(@Valid @RequestBody DepartmentDTO department) {
//
//        departmentService.createDepartment(department);
//
//        return ResponseEntity.ok().build();
//    }
//
//
//}
