package org.example.springboottest2.SS12.controller;

import lombok.RequiredArgsConstructor;
import org.example.springboottest2.SS12.dto.ApiResponse;
import org.example.springboottest2.SS12.dto.Request.AmountRequest;
import org.example.springboottest2.SS12.dto.Request.SupplyRequest;
import org.example.springboottest2.SS12.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/supplies")
@RequiredArgsConstructor
public class SupplyController {

    @Autowired
    private final SupplyService service;

    @PostMapping
    public ResponseEntity<ApiResponse<?>> create(@RequestBody SupplyRequest req) {
        return ResponseEntity.status(201)
                .body(new ApiResponse<>(201, "Created sucess", service.create(req)));
    }

    @PutMapping("/{id}")
    public ApiResponse<?> update(@PathVariable Long id,
                                 @RequestBody Map<String,Object> body) {
        return new ApiResponse<>(200, "update sucessss", service.update(id, body));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ApiResponse<?> getAll() {
        return new ApiResponse<>(200, "get sucess", service.getAll());
    }

    @GetMapping("/search")
    public ApiResponse<?> search(@RequestParam String name) {
        return new ApiResponse<>(200, "search success", service.search(name));
    }

    @PatchMapping("/{id}/export")
    public ApiResponse<?> export(@PathVariable Long id,
                                 @RequestBody AmountRequest req) {
        service.export(id, req.getAmount());
        return new ApiResponse<>(200, "Export success", null);
    }

    @PatchMapping("/{id}/import")
    public ApiResponse<?> importStock(@PathVariable Long id,
                                      @RequestBody AmountRequest req) {
        service.importStock(id, req.getAmount());
        return new ApiResponse<>(200, "Import success", null);
    }

    @GetMapping("/statistics/daily-export")
    public ApiResponse<?> daily() {
        return new ApiResponse<>(200, "daily-export success", service.dailyExport());
    }

    @GetMapping("/statistics/top-export")
    public ApiResponse<?> top() {
        return new ApiResponse<>(200, "top-export success", service.topExport());
    }
}
