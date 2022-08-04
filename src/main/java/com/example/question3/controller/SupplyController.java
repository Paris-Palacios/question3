package com.example.question3.controller;

import com.example.question3.model.Supply;
import com.example.question3.model.SupplyDto;
import com.example.question3.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class SupplyController {

    @Autowired
    SupplyService supplyService;

    @PostMapping(value = "/updateSupply", consumes = {"application/json"})
    public String updateSupply(@RequestBody SupplyDto supply) throws ParseException {

        return supplyService.updateSupply(supply);
    }
}
