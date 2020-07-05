package com.boot.quantitymeasurement.controller;

import com.boot.quantitymeasurement.model.MainUnit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuantityController {

    @GetMapping("/")
    public List<MainUnit> getMainUnit(){
        return null;
    }
}
