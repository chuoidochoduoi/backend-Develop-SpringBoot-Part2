package org.example.springboottest2.SS12.dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TopExportResponse {
    private String topSupplyName;
    private Long totalExportQuantity;
}