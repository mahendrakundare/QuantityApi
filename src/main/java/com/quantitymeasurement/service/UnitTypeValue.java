package com.quantitymeasurement.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class UnitTypeValue {

    public Unit unitValueType(String unitType1) {
        Map<String, Unit> unitMap = new HashMap<>();
        unitType1 = unitType1.toUpperCase();
        Arrays.stream(LengthUnits.values()).forEach(lengthUnits -> unitMap.put(lengthUnits.name().trim(), lengthUnits));
        Arrays.stream(VolumeUnits.values()).forEach(unitOfLength -> unitMap.put(unitOfLength.name().trim(),unitOfLength));
        Arrays.stream(WeightUnits.values()).forEach(unitOfLength -> unitMap.put(unitOfLength.name().trim(),unitOfLength));
        Arrays.stream(TemperatureUnits.values()).forEach(unitOfLength -> unitMap.put(unitOfLength.name().trim(),unitOfLength));

        return unitMap.get(unitType1);
    }
}
