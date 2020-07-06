package com.boot.quantitymeasurement.service;


import com.boot.quantitymeasurement.dto.MainUnitDto;
import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.model.QuantityConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class QuantityService {
    public List<Unit.MainUnit> getMainUnit() {
        List<Unit.MainUnit> mainUnits = new ArrayList<>();
        Arrays.stream(Unit.MainUnit.values()).forEach(u -> mainUnits.add(u));
        return mainUnits;
    }

    public List<Unit.SubUnit> getSubUnit(Unit.MainUnit mainUnit) {
        return null;
    }

    public QuantityConverter getConvertedQuantity(QuantityConverter quantity) {
        return null;
    }
}
