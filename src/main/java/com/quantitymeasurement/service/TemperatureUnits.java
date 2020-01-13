package com.quantitymeasurement.service;

public enum TemperatureUnits implements Unit
{
   FAHRENHEIT(32.0), CELSIUS(1.0);
   private final double valueOfTemperature;

   TemperatureUnits(double valueOfTemperature)
   {
      this.valueOfTemperature = valueOfTemperature;
   }

   @Override
   public Double convertValue(Double valueOfUnit)
   {
      if (this.equals(FAHRENHEIT))
         return (valueOfUnit - this.valueOfTemperature) * 5 / 9;
      return this.valueOfTemperature * valueOfUnit;
   }
}
