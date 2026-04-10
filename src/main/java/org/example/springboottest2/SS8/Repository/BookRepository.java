package org.example.springboottest2.SS8.Repository;

import org.example.springboottest2.SS8.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {


}
