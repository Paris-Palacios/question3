package com.example.question3.service;

import com.example.question3.model.Supply;
import com.example.question3.model.SupplyDto;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SupplyService {

    private List<Supply> supplies;

    public String updateSupply(SupplyDto supplyDto) throws ParseException {

        setSupplies();
        Supply supplyEntry = mapSupplyDtoToSupply(supplyDto);
        Supply supplyOriginal = getSupplyById(supplyEntry.getProductId());

        Date supplyEntryDate = supplyEntry.getUpdateTimeStamp();
        Date supplyOriginalDate = supplyOriginal.getUpdateTimeStamp();

        if(compareTimeStamp(supplyEntryDate,supplyOriginalDate) >= 0) {

          supplies =  supplies.stream()
                    .filter(supply -> supply.getProductId()
                            .equalsIgnoreCase(supplyEntry.getProductId()))
                    .map(supply -> new Supply(supply.getProductId(),
                            supplyEntryDate,
                            supply.getQuantity() + supplyEntry.getQuantity(),
                            "Updated")
                    )
                    .collect(Collectors.toList());

           Supply supplyResponse = supplies.stream()
                    .filter(supply -> supply.getProductId()
                            .equalsIgnoreCase(supplyEntry.getProductId()))
                    .findFirst()
                    .orElseThrow();

            Gson gson = new Gson();

            return gson.toJson(supplyResponse);

        } else {

            supplies =  supplies.stream()
                    .filter(supply -> supply.getProductId()
                            .equalsIgnoreCase(supplyEntry.getProductId()))
                    .map(supply -> new Supply(supply.getProductId(),
                            supply.getUpdateTimeStamp(),
                            supply.getQuantity(),
                            "Out of Sync Update")
                    )
                    .collect(Collectors.toList());

            Supply supplyResponse = supplies.stream()
                    .filter(supply -> supply.getProductId()
                            .equalsIgnoreCase(supplyEntry.getProductId()))
                    .findFirst()
                    .orElseThrow();

            Gson gson = new Gson();

            return gson.toJson(supplyResponse);
        }

    }

    private Supply mapSupplyDtoToSupply(SupplyDto supplyDto) throws ParseException {
        return Supply.builder()
                .productId(supplyDto.getProductId())
                .updateTimeStamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                        .parse(supplyDto.getUpdateTimeStamp()))
                .quantity(supplyDto.getQuantity())
                .build();
    }

    public int compareTimeStamp(Date timeStampEntry, Date timeStampOriginal){
        return timeStampEntry.compareTo(timeStampOriginal);
    }

    public void setSupplies() throws ParseException {
        this.supplies = Supply.getSupplyRecords();
    }
    public Supply getSupplyById(String supplyId) {
       return this.supplies.stream()
                .filter(supply -> supply.getProductId().equalsIgnoreCase(supplyId))
                .findFirst()
                .orElseThrow();
    }
}
