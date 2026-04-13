package org.example.springboottest2.SS9.Service;

import org.example.springboottest2.SS9.DTO.DepartmentDTO;
import org.example.springboottest2.SS9.Repository.DepartmentRepository;
import org.example.springboottest2.SS9.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;
    public void createDepartment(DepartmentDTO departmentDTO) {


        Department department = new Department();
        department.setName(departmentDTO.getName());
        department.setDescription(departmentDTO.getDescription());
        departmentRepository.save(department);
    }
}
