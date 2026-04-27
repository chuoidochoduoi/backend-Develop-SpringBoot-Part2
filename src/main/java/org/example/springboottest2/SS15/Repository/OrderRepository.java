package org.example.springboottest2.SS15.Repository;

import org.example.springboottest2.SS15.model.Order;
import org.example.springboottest2.SS15.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUser(User user);
}