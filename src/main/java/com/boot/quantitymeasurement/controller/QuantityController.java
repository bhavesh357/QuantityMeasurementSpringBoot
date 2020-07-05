package com.boot.quantitymeasurement.controller;

import com.boot.quantitymeasurement.dto.MainUnitDto;
import com.boot.quantitymeasurement.model.MainUnit;
import com.boot.quantitymeasurement.model.QuantityConverter;
import com.boot.quantitymeasurement.model.SubUnit;
import com.boot.quantitymeasurement.service.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuantityController {

    @Autowired
    QuantityService service;

    @GetMapping("/")
    public List<MainUnit> getMainUnit(){
        return service.getMainUnit();
    }

    @GetMapping("/unit")
    public List<SubUnit> getSubUnit(@RequestBody MainUnitDto mainUnit){
        return service.getSubUnit(mainUnit);
    }

    @PostMapping("/unit")
    public QuantityConverter getConvertedQuantity(@RequestBody QuantityConverter quantity){
        return null;
    }
}
