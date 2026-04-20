package org.example.springboottest2.SS12.dto.Response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyExportResponse {
    private Long supplyId;
    private String supplyName;
    private Long totalExportQuantity;
}
