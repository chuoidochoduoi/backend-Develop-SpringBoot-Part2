package org.example.springboottest2.SS7.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {


    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String fullName;
    String email;

    int age;
    int yearsOfExperience;

    private String address;
    private String bio;
    String phone;

}
