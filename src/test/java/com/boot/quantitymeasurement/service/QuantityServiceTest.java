package com.boot.quantitymeasurement.service;


import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.model.Quantity;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class QuantityServiceTest {

    @Autowired
    QuantityService service;

    private List<Unit.MainUnit> mainUnits;
    private List<Unit.SubUnit> subUnits;

    @Test
    public void givenNothing_ShouldReturnList() {
        List<Unit.MainUnit> mainUnits = new ArrayList<>();
        Arrays.stream(Unit.MainUnit.values()).forEach(u -> mainUnits.add(u));
        List<Unit.MainUnit> returnedUnitList = service.getMainUnit();
        Assert.assertEquals(mainUnits,returnedUnitList);
    }

    @Test
    public void givenMainUnit_ShouldReturnList() {
        ArrayList<Unit.SubUnit> subUnits = new ArrayList<>();
        Arrays.stream(Unit.SubUnit.values()).
                filter(u -> u.getMainUnit().equals(Unit.MainUnit.LENGTH)).
                forEach(u -> subUnits.add(u));
        Assert.assertEquals(subUnits,service.getSubUnit(Unit.MainUnit.LENGTH));
    }

    @Test
    public void givenQuantity_ShouldReturnConvertedQuantity() {
        Quantity quantity = new Quantity(Unit.MainUnit.LENGTH, Unit.SubUnit.FEET, 1, Unit.SubUnit.INCH, 0);
        Quantity quantity1 = service.getConvertedQuantity(quantity);
        Assert.assertEquals(12,quantity1.getSizeTwo());
    }
}
