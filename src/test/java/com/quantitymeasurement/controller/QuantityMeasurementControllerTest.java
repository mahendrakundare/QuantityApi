package com.quantitymeasurement.controller;
import com.quantitymeasurement.exception.QuantityMeasurementException;
import com.quantitymeasurement.model.QuantityMeasurementModel;
import com.quantitymeasurement.service.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QuantityMeasurementControllerTest {

    private QuantityMeasurementServices measurementService;
    QuantityMeasurementModel measurementMode1;

    @BeforeEach
    void setUp() {
        measurementService = mock(QuantityMeasurementServices.class);
        measurementMode1 = new QuantityMeasurementModel(1.0, 1.0, "FEET", "FEET");
    }

    @Test
    public void givenOneYardAndOneYard_WhenCompareMethodMock_ShouldReturnTrue() {
        try {
            QuantityMeasurementController measurementController = new QuantityMeasurementController();
            measurementController.setService(measurementService);
            when(measurementService.compare(measurementMode1)).thenReturn(true);
            boolean compare = measurementController.compare(measurementMode1);
            Assert.assertTrue(compare);
        } catch (QuantityMeasurementException e) {
        }
    }

    @Test
    void givenOneFeetAndTwelveInch_ShouldReturnTwentyInch() throws QuantityMeasurementException {
        QuantityMeasurementController measurementController = new QuantityMeasurementController();
        measurementController.setService(measurementService);
        when(measurementService.addUnits(measurementMode1)).thenReturn(24.0);
        Double additionOfUnit = measurementController.addTwoUnit(measurementMode1);
        Assert.assertEquals(24.0,additionOfUnit,0.0);
    }
}