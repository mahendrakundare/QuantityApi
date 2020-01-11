package com.quantitymeasurementapi.service;

public enum UnitOfLength implements Unit
{
   INCH(1), FEET(12), YARD(36), CENTI_METER(0.4);
   public final double valueOfLength;

   UnitOfLength(double valueOfLength)
   {
      this.valueOfLength = valueOfLength;
   }

   @Override
   public Double convertValue(Double valueOfUnit)
   {
      return this.valueOfLength * valueOfUnit;
   }
}
