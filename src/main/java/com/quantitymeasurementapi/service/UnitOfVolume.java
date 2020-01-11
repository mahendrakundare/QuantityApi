package com.quantitymeasurementapi.service;

public enum UnitOfVolume implements Unit
{
   GALLON(3.78), LITRE(1.0), MILLI_LITRE(0.001);
   public final double valueOfVolume;

   UnitOfVolume(double value)
   {
      this.valueOfVolume = value;
   }

   @Override
   public Double convertValue(Double valueOfUnit)
   {
      return this.valueOfVolume * valueOfUnit;
   }
}
