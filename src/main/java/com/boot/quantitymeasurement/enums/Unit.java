package com.boot.quantitymeasurement.enums;

public class Unit {
    public enum MainUnit {
        LENGTH,WEIGHT

    }

    public enum SubUnit {
        FEET(MainUnit.LENGTH),INCH(MainUnit.LENGTH), CM(MainUnit.LENGTH), YARD(MainUnit.LENGTH),KG(MainUnit.WEIGHT), GRAM(MainUnit.WEIGHT), TON(MainUnit.WEIGHT);
        private MainUnit mainUnit;


        SubUnit(MainUnit mainUnit) {
            this.mainUnit=mainUnit;
        }

        public MainUnit getMainUnit() {
            return mainUnit;
        }
    }


}
