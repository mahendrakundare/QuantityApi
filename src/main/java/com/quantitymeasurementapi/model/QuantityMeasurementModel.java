package com.quantitymeasurementapi.model;

public class QuantityMeasurementModel {
    Double unit1;
    Double unit2;
    String unitType1;
    String unitType2;

    public Double getUnit1() {
        return unit1;
    }

    public Double getUnit2() {
        return unit2;
    }

    public String getUnitType1() {
        return unitType1;
    }

    public String getUnitType2() {
        return unitType2;
    }

    @Override
    public String toString() {
        return "QuantityMeasurementModel{" +
                "unit1=" + unit1 +
                ", unit2=" + unit2 +
                ", unitType1='" + unitType1 + '\'' +
                ", unitType2='" + unitType2 + '\'' +
                '}';
    }
}
