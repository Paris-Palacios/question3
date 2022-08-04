package com.example.question3.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SupplyDto {
    private String productId;
    private String updateTimeStamp;
    private Double quantity;
}
