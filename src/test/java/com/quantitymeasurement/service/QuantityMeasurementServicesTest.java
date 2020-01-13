package com.quantitymeasurement.service;

import com.quantitymeasurement.model.QuantityMeasurementModel;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuantityMeasurementServicesTest {

    QuantityMeasurementModel measurementModel;

    @Before
    public void setUp() throws Exception {
        measurementModel = new QuantityMeasurementModel(1.0, 1.0, "FEET", "FEET");
    }

    @Test
    public void given1FeetAnd1Feet_WhenEqual_ShouldReturnTrue() {

    }
}