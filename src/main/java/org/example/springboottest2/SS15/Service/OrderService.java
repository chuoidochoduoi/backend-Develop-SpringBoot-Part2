package org.example.springboottest2.SS15.Service;

import org.example.springboottest2.SS15.DTO.OrderItemRequest;
import org.example.springboottest2.SS15.DTO.OrderRequest;
import org.example.springboottest2.SS15.Repository.OrderItemRepository;
import org.example.springboottest2.SS15.Repository.OrderRepository;
import org.example.springboottest2.SS15.Repository.ProductRepository;
import org.example.springboottest2.SS15.Repository.UserRepository;
import org.example.springboottest2.SS15.model.Order;
import org.example.springboottest2.SS15.model.OrderItem;
import org.example.springboottest2.SS15.model.Product;
import org.example.springboottest2.SS15.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepo;

    @Autowired
    private OrderItemRepository itemRepo;

    @Autowired
    private ProductRepository productRepo;

    @Autowired
    private UserRepository userRepo;

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext()
                .getAuthentication().getName();

        return userRepo.findByEmail(email).orElseThrow();
    }

    public Order createOrder(OrderRequest request) {

        User user = getCurrentUser();

        Order order = new Order();
        order.setUser(user);
        order.setCreatedDate(LocalDateTime.now());
        order.setStatus("NEW");

        order = orderRepo.save(order);

        double total = 0;

        for (OrderItemRequest itemReq : request.getItems()) {

            Product product = productRepo.findById(itemReq.getProductId())
                    .orElseThrow();

            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(product);
            item.setQuantity(itemReq.getQuantity());
            item.setPriceBuy(product.getPrice().doubleValue());

            total += item.getQuantity() * item.getPriceBuy();

            itemRepo.save(item);
        }

        order.setTotalMoney(total);

        return orderRepo.save(order);
    }

    public List<Order> myOrders() {
        User user = getCurrentUser();
        return orderRepo.findByUser(user);
    }

    public List<Order> getAll() {
        return orderRepo.findAll();
    }

    public Order updateStatus(Long id, String status) {
        Order order = orderRepo.findById(id).orElseThrow();
        order.setStatus(status);
        return orderRepo.save(order);
    }
}
