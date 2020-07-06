package com.boot.quantitymeasurement.service;


import com.boot.quantitymeasurement.dto.MainUnitDto;
import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.model.QuantityConverter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantityService {
    public List<Unit.MainUnit> getMainUnit() {
        return null;
    }

    public List<Unit.SubUnit> getSubUnit(MainUnitDto mainUnit) {
        return null;
    }

    public QuantityConverter getConvertedQuantity(QuantityConverter quantity) {
        return null;
    }
}
