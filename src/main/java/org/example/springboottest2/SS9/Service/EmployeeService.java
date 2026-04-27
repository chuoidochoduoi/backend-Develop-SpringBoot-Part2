//package org.example.springboottest2.SS9.Service;
//
//import org.example.springboottest2.SS9.DTO.EmployeeCreateDTO;
//import org.example.springboottest2.SS9.Exception.DuplicateResourceException;
//import org.example.springboottest2.SS9.Exception.ResourceNotFoundException;
//import org.example.springboottest2.SS9.Repository.DepartmentRepository;
//import org.example.springboottest2.SS9.Repository.EmployeeRepository;
//import org.example.springboottest2.SS9.model.Department;
//import org.example.springboottest2.SS9.model.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class EmployeeService {
//    @Autowired
//    EmployeeRepository employeeRepository;
//
//    @Autowired
//    DepartmentRepository departmentRepository;
//
//
//    public void AddEmployee(EmployeeCreateDTO employeeCreateDTO) {
//
//        Department department = departmentRepository
//                .findById(employeeCreateDTO.getDepartmentId())
//                .orElseThrow(() -> new ResourceNotFoundException("Phòng ban không tồn tại"));
//
//        if (employeeRepository.existsByEmail(employeeCreateDTO.getEmail())) {
//            throw new DuplicateResourceException("Email đã được sử dụng");
//        }
//
//        Employee employee = new Employee();
//        employee.setEmail(employeeCreateDTO.getEmail());
//        employee.setPhone(employeeCreateDTO.getPhone());
//        employee.setFullName(employeeCreateDTO.getFullName());
//        employee.setSalary(employeeCreateDTO.getSalary());
//
//
//        employee.setDepartment(department);
//
//        employeeRepository.save(employee);
//
//
//    }
//}
