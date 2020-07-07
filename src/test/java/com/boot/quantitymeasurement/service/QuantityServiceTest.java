package com.boot.quantitymeasurement.service;


import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.exception.QuantityException;
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
    public void givenQuantity_WhenLengthShouldReturnConvertedQuantity() {
        Quantity quantity = new Quantity(Unit.MainUnit.LENGTH, Unit.SubUnit.FEET, 1, Unit.SubUnit.INCH, 0);
        Quantity quantity1 = service.getConvertedQuantity(quantity);
        Assert.assertEquals(12,quantity1.getSizeTwo(),0.2);
    }


    @Test
    public void givenQuantity_WhenInchAndFeet_ShouldReturnConvertedQuantity() {
        Quantity quantity = new Quantity(Unit.MainUnit.LENGTH, Unit.SubUnit.INCH, 24, Unit.SubUnit.FEET, 0);
        Quantity quantity1 = service.getConvertedQuantity(quantity);
        Assert.assertEquals(2,quantity1.getSizeTwo(),0.2);
    }

    // length tests end here

    @Test
    public void givenQuantity_WhenWeight_ShouldReturnConvertedQuantity() {
        Quantity quantity = new Quantity(Unit.MainUnit.WEIGHT, Unit.SubUnit.GRAM, 1000000, Unit.SubUnit.TON, 0);
        Quantity quantity1 = service.getConvertedQuantity(quantity);
        Assert.assertEquals(1,quantity1.getSizeTwo(),0.2);
    }

    @Test
    public void givenQuantity_WhenWeightTonAndKG_ShouldReturnConvertedQuantity() {
        Quantity quantity = new Quantity(Unit.MainUnit.WEIGHT, Unit.SubUnit.TON, 3, Unit.SubUnit.KG, 0);
        Quantity quantity1 = service.getConvertedQuantity(quantity);
        Assert.assertEquals(3000,quantity1.getSizeTwo(),0.2);
    }

    //weight tests ends here

    @Test
    public void givenQuantity_WhenTemp_ShouldReturnConvertedQuantity() {
        Quantity quantity = new Quantity(Unit.MainUnit.TEMP, Unit.SubUnit.F, 212, Unit.SubUnit.C, 0);
        Quantity quantity1 = service.getConvertedQuantity(quantity);
        Assert.assertEquals(100,quantity1.getSizeTwo(),0.2);
    }

    @Test
    public void givenQuantity_WhenTempCToF_ShouldReturnConvertedQuantity() {
        Quantity quantity = new Quantity(Unit.MainUnit.TEMP, Unit.SubUnit.C, 100, Unit.SubUnit.F, 0);
        Quantity quantity1 = service.getConvertedQuantity(quantity);
        Assert.assertEquals(212,quantity1.getSizeTwo(),0.2);
    }

    // temp test ends here

    @Test
    public void givenQuantity_WhenVolume_ShouldReturnConvertedQuantity() {
        Quantity quantity = new Quantity(Unit.MainUnit.VOLUME, Unit.SubUnit.ML, 3000, Unit.SubUnit.LITRE, 0);
        Quantity quantity1 = service.getConvertedQuantity(quantity);
        Assert.assertEquals(3,quantity1.getSizeTwo(),0.2);
    }

    @Test
    public void givenQuantity_WhenVolumeMLToLitre_ShouldReturnConvertedQuantity() {
        Quantity quantity = new Quantity(Unit.MainUnit.VOLUME, Unit.SubUnit.GALLON, 1, Unit.SubUnit.LITRE, 0);
        Quantity quantity1 = service.getConvertedQuantity(quantity);
        Assert.assertEquals(3.785,quantity1.getSizeTwo(),0.2);
    }

    //volume tests ends here


    @Test
    public void givenMainUnit_WhenImproper_ShouldReturnNull(){
        try{
            service.getSubUnit(Unit.MainUnit.Hair);
        }
        catch (QuantityException ex) {
            Assert.assertEquals(400, ex.getCode());
        }
    }

    @Test
    public void givenImproperQuantity_WhenMainUnit_ShouldReturnConvertedQuantity(){
        Quantity quantity = new Quantity(Unit.MainUnit.Hair, Unit.SubUnit.GALLON, 1, Unit.SubUnit.LITRE, 0);
        try{
            Quantity convertedQuantity = service.getConvertedQuantity(quantity);
        }catch (QuantityException ex){
            Assert.assertEquals(400,ex.getCode());
        }
    }

    @Test
    public void givenImproperQuantity_WhenSubUnit_ShouldReturnConvertedQuantity(){
        Quantity quantity = new Quantity(Unit.MainUnit.VOLUME, Unit.SubUnit.FEET, 1, Unit.SubUnit.CM, 0);
        try{
            Quantity convertedQuantity = service.getConvertedQuantity(quantity);
        }catch (QuantityException ex){
            Assert.assertEquals(400,ex.getCode());
        }
    }
}
