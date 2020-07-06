package com.boot.quantitymeasurement.controller;

import com.boot.quantitymeasurement.dto.MainUnitDto;
import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.model.QuantityConverter;
import com.boot.quantitymeasurement.service.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuantityController {

    @Autowired
    QuantityService service;

    @GetMapping("/")
    public List<Unit.MainUnit> getMainUnit(){
        return service.getMainUnit();
    }

    @GetMapping("/unit")
    public List<Unit.SubUnit> getSubUnit(@RequestBody Unit.MainUnit mainUnit){
        return service.getSubUnit(mainUnit);
    }

    @PostMapping("/unit")
    public QuantityConverter getConvertedQuantity(@RequestBody QuantityConverter quantity){
        return null;
    }
}
