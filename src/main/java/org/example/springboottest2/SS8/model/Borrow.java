package org.example.springboottest2.SS8.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Borrow {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String username;
    int bookId;
}
