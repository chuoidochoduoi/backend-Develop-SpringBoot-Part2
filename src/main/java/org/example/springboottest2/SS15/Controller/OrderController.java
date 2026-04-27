package org.example.springboottest2.SS15.Controller;

import org.example.springboottest2.SS15.DTO.OrderRequest;
import org.example.springboottest2.SS15.Service.OrderService;
import org.example.springboottest2.SS15.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService service;
    @PostMapping
    public Order create(@RequestBody OrderRequest request) {
        return service.createOrder(request);
    }

    @GetMapping("/my")
    public List<Order> myOrders() {
        return service.myOrders();
    }

    @GetMapping
    public List<Order> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}/status")
    public Order updateStatus(@PathVariable Long id,
                              @RequestParam String status) {
        return service.updateStatus(id, status);
    }
}
