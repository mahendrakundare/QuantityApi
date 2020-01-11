package com.quantitymeasurementapi.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class UnitTypeVale {

    public Unit unitValueType(String unitType1) {
        Map<String, Unit> unitMap = new HashMap<>();
        unitType1 = unitType1.toUpperCase();
        Arrays.stream(UnitOfLength.values()).forEach(unitOfLength -> unitMap.put(unitOfLength.name().trim(),unitOfLength));
        Arrays.stream(UnitOfVolume.values()).forEach(unitOfLength -> unitMap.put(unitOfLength.name().trim(),unitOfLength));
        Arrays.stream(UnitOfWeights.values()).forEach(unitOfLength -> unitMap.put(unitOfLength.name().trim(),unitOfLength));
        Arrays.stream(UnitOfTemperature.values()).forEach(unitOfLength -> unitMap.put(unitOfLength.name().trim(),unitOfLength));

        return unitMap.get(unitType1);
    }
}
