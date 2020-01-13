package com.quantitymeasurement.controller;

import com.quantitymeasurement.exception.QuantityMeasurementException;
import com.quantitymeasurement.model.QuantityMeasurementModel;
import com.quantitymeasurement.service.QuantityMeasurementServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/measurement")
public class QuantityMeasurementController {

    @Autowired
    QuantityMeasurementServices measurementServices;


    @GetMapping("/get")
    public boolean compare(@RequestBody QuantityMeasurementModel quantityMeasurementModel) throws QuantityMeasurementException {
       return measurementServices.compare(quantityMeasurementModel);
    }

    @GetMapping("/unitsaddition")
    public Double addTwoUnit(@RequestBody QuantityMeasurementModel quantityMeasurementModel) throws QuantityMeasurementException {
        return measurementServices.addUnits(quantityMeasurementModel);
    }

    public void setService(QuantityMeasurementServices measurementService) {
        measurementServices = measurementService;
    }
}
