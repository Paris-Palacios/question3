package com.example.question3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class Supply {
    private String productId;
    private Date updateTimeStamp;
    private Double quantity;
    private String status;

    public static List<Supply> getSupplyRecords() throws ParseException {

        Supply supply1 = Supply.builder()
                .productId("Product1")
                .updateTimeStamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                        .parse("2021-03-16T08:53:48.616Z"))
                .quantity(10.0)
                .build();

        Supply supply2 = Supply.builder()
                .productId("Product2")
                .updateTimeStamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                        .parse("2021-03-16T08:59:48.616Z"))
                .quantity(5.0)
                .build();

        Supply supply3 = Supply.builder()
                .productId("Product3")
                .updateTimeStamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                        .parse("2021-03-16T09:10:48.616Z"))
                .quantity(30.0)
                .build();

        Supply supply4 = Supply.builder()
                .productId("Product4")
                .updateTimeStamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                        .parse("2021-03-16T09:10:48.616Z"))
                .quantity(20.0)
                .build();

        return List.of(supply1, supply2, supply3, supply4);
    }

    public void setUpdateTimeStamp(Date updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }
}
