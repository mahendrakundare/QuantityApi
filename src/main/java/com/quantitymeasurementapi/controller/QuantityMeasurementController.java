package com.quantitymeasurementapi.controller;

import com.quantitymeasurementapi.exception.QuantityMeasurementException;
import com.quantitymeasurementapi.model.QuantityMeasurementModel;
import com.quantitymeasurementapi.service.UnitTypeVale;
import com.quantitymeasurementapi.service.QuantityMeasurement;
import com.quantitymeasurementapi.service.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/measurement")
public class QuantityMeasurementController {

    @Autowired
    UnitTypeVale unitTypeVale;

    @GetMapping("/get")
    public boolean compare(@RequestBody QuantityMeasurementModel quantityMeasurementModel) throws QuantityMeasurementException {
        Unit unitType1 = unitTypeVale.unitValueType(quantityMeasurementModel.getUnitType1());
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(quantityMeasurementModel.getUnit1(),unitType1);
        Unit unitType2 = unitTypeVale.unitValueType(quantityMeasurementModel.getUnitType2());
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(quantityMeasurementModel.getUnit2(),unitType2);
        return quantityMeasurement.compare(quantityMeasurement1);
    }

    @GetMapping("/addUnits")
    public Double addTwoUnit(@RequestBody QuantityMeasurementModel quantityMeasurementModel) throws QuantityMeasurementException {
        Unit unitType1 = unitTypeVale.unitValueType(quantityMeasurementModel.getUnitType1());
        QuantityMeasurement quantityMeasurement = new QuantityMeasurement(quantityMeasurementModel.getUnit1(),unitType1);
        Unit unitType2 = unitTypeVale.unitValueType(quantityMeasurementModel.getUnitType2());
        QuantityMeasurement quantityMeasurement1 = new QuantityMeasurement(quantityMeasurementModel.getUnit2(),unitType2);
        return quantityMeasurement.additionOfTwoUnits(quantityMeasurement1);
    }
}
