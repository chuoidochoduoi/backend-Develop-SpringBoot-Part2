package org.example.springboottest2.SS15.Controller;

import org.example.springboottest2.SS15.DTO.UpdateRoleRequest;
import org.example.springboottest2.SS15.Service.UserService;
import org.example.springboottest2.SS15.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PutMapping("/{id}/role")
    public User updateRole(@PathVariable Long id,
                           @RequestBody UpdateRoleRequest request) {

        return service.updateRole(id, request.getRole());
    }

    @GetMapping("/profile")
    public User profile() {
        return service.getProfile();
    }
}
