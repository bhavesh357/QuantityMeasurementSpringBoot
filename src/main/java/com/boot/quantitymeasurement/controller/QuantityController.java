package com.boot.quantitymeasurement.controller;

import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.model.Quantity;
import com.boot.quantitymeasurement.model.Response;
import com.boot.quantitymeasurement.service.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuantityController {

    @Autowired
    QuantityService service;

    @GetMapping("/")
    public Response getMainUnit(){
        return new Response(200,"Successful",service.getMainUnit());
    }

    @GetMapping("/unit")
    public Response getSubUnit(@RequestBody Unit.MainUnit mainUnit){
        return new Response(200,"Successful",service.getSubUnit(mainUnit));
    }

    @PostMapping("/unit")
    public Response getConvertedQuantity(@RequestBody Quantity quantity){
        return new Response(200,"Successful",service.getConvertedQuantity(quantity));
    }
}
