package com.quantitymeasurement.service;

public enum VolumeUnits implements Unit
{
   GALLON(3.78), LITRE(1.0), MILLI_LITRE(0.001);
   public final double valueOfVolume;

   VolumeUnits(double value)
   {
      this.valueOfVolume = value;
   }

   @Override
   public Double convertValue(Double valueOfUnit)
   {
      return this.valueOfVolume * valueOfUnit;
   }
}
