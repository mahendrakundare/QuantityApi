package com.quantitymeasurement.service;

public enum WeightUnits implements Unit
{
   KILOGRAM(1.0), GRAM(0.001), TONNE(1000.0);

   private final double valueWeights;

   WeightUnits(double valueWeights)
   {
      this.valueWeights = valueWeights;
   }

   @Override
   public Double convertValue(Double valueOfUnit)
   {
      return this.valueWeights * valueOfUnit;
   }
}
