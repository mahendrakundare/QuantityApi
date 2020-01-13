package com.quantitymeasurement.service;

import com.quantitymeasurement.exception.QuantityMeasurementException;
import org.springframework.stereotype.Service;

@Service
public class QuantityMeasurement {
    private Double value;
    private Unit unit;

    public QuantityMeasurement() {
    }

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public QuantityMeasurement(Double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public boolean compare(QuantityMeasurement that) throws QuantityMeasurementException {
        if (!this.unit.getClass().equals(that.unit.getClass()))
            throw new QuantityMeasurementException("Error! different Unit Type", QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE);
        Double firstValue = this.unit.convertValue(this.value);
        Double secondValue = that.unit.convertValue(that.value);
        return (Double.compare(Math.round(firstValue), Math.round(secondValue)) == 0);
    }

    public Double additionOfTwoUnits(QuantityMeasurement that) throws QuantityMeasurementException {
        if (this.unit.getClass().getName().equals(TemperatureUnits.class.getName()) | that.unit.getClass().getName().equals(TemperatureUnits.class.getName()))
            throw new QuantityMeasurementException("parameter units cant be added", QuantityMeasurementException.ExceptionType.UNIT_NOT_ADDABLE);
        Double firstValue = this.unit.convertValue(this.value);
        Double secondValue = that.unit.convertValue(that.value);
        return (firstValue + secondValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuantityMeasurement quantityMeasurement = (QuantityMeasurement) o;
        return Double.compare(quantityMeasurement.value, value) == 0 &&
                unit == quantityMeasurement.unit;
    }
}



