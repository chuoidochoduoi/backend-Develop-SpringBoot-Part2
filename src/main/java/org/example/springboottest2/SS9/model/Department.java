package org.example.springboottest2.SS9.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
@Id
        @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
String name;
String description;


    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
