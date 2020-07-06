package com.boot.quantitymeasurement.service;


import com.boot.quantitymeasurement.enums.Unit;
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
}