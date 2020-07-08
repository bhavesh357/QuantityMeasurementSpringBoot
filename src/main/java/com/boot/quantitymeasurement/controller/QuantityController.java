package com.boot.quantitymeasurement.controller;

import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.exception.QuantityException;
import com.boot.quantitymeasurement.model.Quantity;
import com.boot.quantitymeasurement.model.Response;
import com.boot.quantitymeasurement.service.QuantityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class QuantityController {

    @Autowired
    QuantityService service;

    @GetMapping("/")
    public Response getMainUnit(){
        return new Response(200,"Successful",service.getMainUnit());
    }

    @GetMapping("/unit")
    public Response getSubUnit(@RequestParam Unit.MainUnit mainUnit){
        return new Response(200,"Successful",service.getSubUnit(mainUnit));
    }

    @PostMapping("/unit")
    public Response getConvertedQuantity(@Valid @RequestBody Quantity quantity){
        return new Response(200,"Successful",service.getConvertedQuantity(quantity));
    }

    @ExceptionHandler(QuantityException.class)
    public Response handleQuantityException(QuantityException ex){
        return new Response(ex.getCode(),ex.getMessage(),null);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new Response(400,"Please Enter Valid Quantity",errors);
    }


}
