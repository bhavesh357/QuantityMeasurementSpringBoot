package com.boot.quantitymeasurement.controller;

import com.boot.quantitymeasurement.dto.MainUnitDto;
import com.boot.quantitymeasurement.model.MainUnit;
import com.boot.quantitymeasurement.model.SubUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuantityController {

    @GetMapping("/")
    public List<MainUnit> getMainUnit(){
        return null;
    }

    @GetMapping("/unit")
    public List<SubUnit> getSubUnit(@RequestBody MainUnitDto mainUnitDto){
        return null;
    }

}
