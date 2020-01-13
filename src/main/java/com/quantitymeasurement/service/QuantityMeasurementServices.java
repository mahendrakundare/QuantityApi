package com.quantitymeasurement.service;

import com.quantitymeasurement.exception.QuantityMeasurementException;
import com.quantitymeasurement.model.QuantityMeasurementModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuantityMeasurementServices {

    @Autowired
    UnitTypeValue unitTypeValue;

    public boolean compare(QuantityMeasurementModel quantityMeasurementModel) throws QuantityMeasurementException {
        Unit unitType1 = unitTypeValue.unitValueType(quantityMeasurementModel.getUnitType1());
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(quantityMeasurementModel.getUnitValue1(),unitType1);
        Unit unitType2 = unitTypeValue.unitValueType(quantityMeasurementModel.getUnitType2());
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(quantityMeasurementModel.getUnitValue2(),unitType2);
        return quantityMeasurement.compare(quantityMeasurement1);
    }


    public Double addUnits(QuantityMeasurementModel quantityMeasurementModel) throws QuantityMeasurementException {
        Unit unitType1 = unitTypeValue.unitValueType(quantityMeasurementModel.getUnitType1());
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(quantityMeasurementModel.getUnitValue1(),unitType1);
        Unit unitType2 = unitTypeValue.unitValueType(quantityMeasurementModel.getUnitType2());
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(quantityMeasurementModel.getUnitValue2(),unitType2);
        return quantityMeasurement.additionOfTwoUnits(quantityMeasurement1);
    }
}
