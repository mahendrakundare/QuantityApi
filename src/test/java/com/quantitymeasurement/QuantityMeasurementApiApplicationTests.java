package com.quantitymeasurement;

import com.quantitymeasurement.controller.QuantityMeasurementController;
import com.quantitymeasurement.exception.QuantityMeasurementException;
import com.quantitymeasurement.model.QuantityMeasurementModel;
import com.quantitymeasurement.service.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuantityMeasurementApiApplicationTests {
    @Test
    public void forOneFeetAndAnotherOneFeet_ShouldReturnEqual()
    {
        QuantityMeasurement feet1 = new QuantityMeasurement(1.0, LengthUnits.FEET);
        QuantityMeasurement feet2 = new QuantityMeasurement(1.0, LengthUnits.FEET);
        Assert.assertEquals(feet2, feet1);
    }

    @Test
    public void givenOneFeetAndAnotherFeet_ShouldReturnNotEqual()
    {
        QuantityMeasurement feet1 = new QuantityMeasurement(1.0, LengthUnits.FEET);
        QuantityMeasurement feet2 = new QuantityMeasurement(2.0, LengthUnits.FEET);
        Assert.assertNotEquals(feet1, feet2);
    }

    @Test
    public void givenOneInchAndAnotherOneInch_ShouldReturnEqual()
    {
        QuantityMeasurement inch1 = new QuantityMeasurement(0.0, LengthUnits.INCH);
        QuantityMeasurement inch2 = new QuantityMeasurement(0.0, LengthUnits.INCH);
        Assert.assertEquals(inch1, inch2);
    }

    @Test
    public void givenZeroInchAndAnotherOneInch_ShouldReturnNotEqual()
    {
        QuantityMeasurement inch1 = new QuantityMeasurement(0.0, LengthUnits.INCH);
        QuantityMeasurement inch2 = new QuantityMeasurement(2.0, LengthUnits.INCH);
        Assert.assertNotEquals(inch1, inch2);
    }

    @Test
    public void givenOneFeetAndOneInch_ShouldReturnNotEqual()
    {
        QuantityMeasurement inch1 = new QuantityMeasurement(1.0, LengthUnits.FEET);
        QuantityMeasurement feet1 = new QuantityMeasurement(1.0, LengthUnits.INCH);
        Assert.assertNotEquals(inch1, feet1);
    }

    @Test
    public void comparingZeroInchAndZeroFeet_ShouldReturnEqualLength()
    {
        try
        {
            QuantityMeasurement inch1 = new QuantityMeasurement(0.0, LengthUnits.FEET);
            QuantityMeasurement feet1 = new QuantityMeasurement(0.0, LengthUnits.INCH);
            Boolean compareCheck = feet1.compare(inch1);
            Assert.assertTrue(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void comparingZeroInchAnd1Feet_ShouldReturnNotEqualLength()
    {
        try
        {
            QuantityMeasurement inch1 = new QuantityMeasurement(1.0, LengthUnits.FEET);
            QuantityMeasurement feet1 = new QuantityMeasurement(1.0, LengthUnits.INCH);
            Boolean compareCheck = inch1.compare(feet1);
            Assert.assertFalse(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }


    @Test
    public void givenOneFeetAndOneFeet_WhenCompered_ShouldReturnEqualLength()
    {
        try
        {
            QuantityMeasurement inch1 = new QuantityMeasurement(1.0, LengthUnits.INCH);
            QuantityMeasurement feet1 = new QuantityMeasurement(1.0, LengthUnits.INCH);
            Boolean compareCheck = feet1.compare(inch1);
            Assert.assertTrue(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void givenOneInchAndOneInch_WhenCompered_ShouldReturnEqualLength()
    {
        try
        {
            QuantityMeasurement inch1 = new QuantityMeasurement(1.0, LengthUnits.INCH);
            QuantityMeasurement feet1 = new QuantityMeasurement(1.0, LengthUnits.INCH);
            Boolean compareCheck = feet1.compare(inch1);
            Assert.assertTrue(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void givenOneInchAndOneFeet_WhenCompered_ShouldReturnNotEqualLength()
    {
        try
        {
            QuantityMeasurement inch1 = new QuantityMeasurement(1.0, LengthUnits.INCH);
            QuantityMeasurement feet1 = new QuantityMeasurement(1.0, LengthUnits.FEET);
            Boolean compareCheck = feet1.compare(inch1);
            Assert.assertFalse(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void givenOneInchAndOneInch_WhenCompered_ShouldReturnFalse()
    {
        try
        {
            QuantityMeasurement inch1 = new QuantityMeasurement(1.0, LengthUnits.INCH);
            QuantityMeasurement feet1 = new QuantityMeasurement(1.0, LengthUnits.INCH);
            Boolean compareCheck = feet1.compare(inch1);
            Assert.assertTrue(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void givenOneYardAndOneYard_WhenCompered_ShouldReturnFalse()
    {
        try
        {
            QuantityMeasurement inch1 = new QuantityMeasurement(1.0, LengthUnits.YARD);
            QuantityMeasurement feet1 = new QuantityMeasurement(1.0, LengthUnits.YARD);
            Boolean compareCheck = feet1.compare(inch1);
            Assert.assertTrue(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void givenOneInchAndOneYard_WhenCompered_ShouldReturnFalse()
    {
        try
        {
            QuantityMeasurement inch1 = new QuantityMeasurement(1.0, LengthUnits.INCH);
            QuantityMeasurement yard1 = new QuantityMeasurement(1.0, LengthUnits.YARD);
            Boolean compareCheck = inch1.compare(yard1);
            Assert.assertFalse(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void given36InchAndOneYard_WhenCompered_ShouldReturnTrue()
    {
        try
        {
            QuantityMeasurement inch1 = new QuantityMeasurement(36.0, LengthUnits.INCH);
            QuantityMeasurement yard1 = new QuantityMeasurement(1.0, LengthUnits.YARD);
            Boolean compareCheck = inch1.compare(yard1);
            Assert.assertTrue(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void given3FeetAndOneYard_WhenCompered_ShouldReturnTrue()
    {
        try
        {
            QuantityMeasurement inch1 = new QuantityMeasurement(3.0, LengthUnits.FEET);
            QuantityMeasurement yard1 = new QuantityMeasurement(1.0, LengthUnits.YARD);
            Boolean compareCheck = inch1.compare(yard1);
            Assert.assertTrue(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void givenOneFeetAnd3Yard_WhenCompered_ShouldReturnFalse()
    {
        try
        {
            QuantityMeasurement feet1 = new QuantityMeasurement(1.0, LengthUnits.FEET);
            QuantityMeasurement yard1 = new QuantityMeasurement(3.0, LengthUnits.YARD);
            Boolean compareCheck = feet1.compare(yard1);
            Assert.assertFalse(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void given2InchAnd5CentiMeter_WhenCompered_ShouldReturnTrue()
    {
        try
        {
            QuantityMeasurement inch = new QuantityMeasurement(2.0, LengthUnits.INCH);
            QuantityMeasurement centiMeter = new QuantityMeasurement(5.0, LengthUnits.CENTI_METER);
            Boolean compareCheck = inch.compare(centiMeter);
            Assert.assertTrue(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void givenOneUnitType_WhenComperedToDifferentUnitType_ShouldThrowException()
    {
        try
        {
            QuantityMeasurement gallon = new QuantityMeasurement(1.0, VolumeUnits.GALLON);
            QuantityMeasurement litre = new QuantityMeasurement(3.78, LengthUnits.INCH);
            Boolean compareCheck = gallon.compare(litre);
            Assert.assertTrue(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void givenOneGallonAnd3p78Litre_WhenCompered_ShouldReturnTrue()
    {
        try
        {
            QuantityMeasurement gallon = new QuantityMeasurement(1.0, VolumeUnits.GALLON);
            QuantityMeasurement litre = new QuantityMeasurement(3.78, VolumeUnits.LITRE);
            Boolean compareCheck = gallon.compare(litre);
            Assert.assertTrue(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void givenOneLitreAnd1000MilliLitre_WhenCompered_ShouldReturnTrue()
    {
        try
        {
            QuantityMeasurement litre = new QuantityMeasurement(1.0, VolumeUnits.LITRE);
            QuantityMeasurement milliLitre = new QuantityMeasurement(1000.0, VolumeUnits.MILLI_LITRE);
            Boolean compareCheck = litre.compare(milliLitre);
            Assert.assertTrue(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void givenOneKgAnd1000Grams_WhenCompered_ShouldReturnTrue()
    {
        try
        {
            QuantityMeasurement litre = new QuantityMeasurement(1.0, WeightUnits.KILOGRAM);
            QuantityMeasurement milliLitre = new QuantityMeasurement(1000.0, WeightUnits.GRAM);
            Boolean compareCheck = litre.compare(milliLitre);
            Assert.assertTrue(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void givenOneTonneAnd1000Kgs_WhenCompered_ShouldReturnTrue()
    {
        try
        {
            QuantityMeasurement litre = new QuantityMeasurement(1.0, WeightUnits.TONNE);
            QuantityMeasurement milliLitre = new QuantityMeasurement(1000.0, WeightUnits.KILOGRAM);
            Boolean compareCheck = litre.compare(milliLitre);
            Assert.assertTrue(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {
            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }

    @Test
    public void given212FahrenheitAnd100Celsius_WhenCompered_ShouldReturnTrue()
    {
        try
        {
            QuantityMeasurement fahrenheit = new QuantityMeasurement(212.0, TemperatureUnits.FAHRENHEIT);
            QuantityMeasurement celsius = new QuantityMeasurement(100.0, TemperatureUnits.CELSIUS);
            Boolean compareCheck = fahrenheit.compare(celsius);
            Assert.assertTrue(compareCheck);
        }
        catch (QuantityMeasurementException e)
        {

            Assert.assertEquals(QuantityMeasurementException.ExceptionType.UNIT_NOT_COMPARABLE, e.type);
        }
    }


    @Test
    public void given2InchAnd2Inch_WhenAdd_ShouldReturn4Inch()
    {
        try
        {
            QuantityMeasurement inch2 = new QuantityMeasurement(2.0, LengthUnits.INCH);
            QuantityMeasurement inch1 = new QuantityMeasurement(2.0, LengthUnits.INCH);
            Double additionOfInchAndInch  = inch2.additionOfTwoUnits(inch1);
            Assert.assertEquals(4, additionOfInchAndInch, 0.0);
        }
        catch (QuantityMeasurementException e)
        {
        }
    }

    @Test
    public void given1FeetAnd1Feet_WhenAdd_ShouldReturn24Inch()
    {
        try
        {
            QuantityMeasurement oneFeet1 = new QuantityMeasurement(1.0, LengthUnits.FEET);
            QuantityMeasurement oneFeet2 = new QuantityMeasurement(1.0, LengthUnits.FEET);
            Double additionOfInchAndInch = oneFeet2.additionOfTwoUnits(oneFeet1);
            Assert.assertEquals(24, additionOfInchAndInch, 0.0);
        }
        catch (QuantityMeasurementException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void given1FeetAnd1Feet_WhenAdd_ShouldReturn14Inch()
    {
        try
        {
            QuantityMeasurement oneFeet = new QuantityMeasurement(1.0, LengthUnits.FEET);
            QuantityMeasurement oneInch = new QuantityMeasurement(2.0, LengthUnits.INCH);
            Double additionOfInchAndInch = oneFeet.additionOfTwoUnits(oneInch);
            Assert.assertEquals(14, additionOfInchAndInch, 0.0);
        }
        catch (QuantityMeasurementException e) {
        }
    }

    @Test
    public void given2InchAnd2p5CentiMeter_WhenAdd_ShouldReturn3Inch()
    {
        try
        {
            QuantityMeasurement twoInch = new QuantityMeasurement(2.0, LengthUnits.INCH);
            QuantityMeasurement twoPointFiveCM = new QuantityMeasurement(2.5, LengthUnits.CENTI_METER);
            Double additionOfInchAndInch = twoPointFiveCM.additionOfTwoUnits(twoInch);
            Assert.assertEquals(3, additionOfInchAndInch, 0.0);
        }
        catch (QuantityMeasurementException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenOneGallonAnd3p78Litre_WhenAdd_ShouldReturn7p57Litre()
    {
        try
        {
            QuantityMeasurement twoInch = new QuantityMeasurement(1.0, VolumeUnits.GALLON);
            QuantityMeasurement twoPointFiveCM = new QuantityMeasurement(3.78, VolumeUnits.LITRE);
            Double additionOfInchAndInch = twoPointFiveCM.additionOfTwoUnits(twoInch);
            Assert.assertEquals(7.57, additionOfInchAndInch, 0.1);
        }
        catch (QuantityMeasurementException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenOneThousandMilliLitreAndOneLitre_WhenAdd_ShouldReturn2Litre()
    {
        try
        {
            QuantityMeasurement twoInch = new QuantityMeasurement(1000.0, VolumeUnits.MILLI_LITRE);
            QuantityMeasurement twoPointFiveCM = new QuantityMeasurement(1.0, VolumeUnits.LITRE);
            Double additionOfInchAndInch = twoPointFiveCM.additionOfTwoUnits(twoInch);
            Assert.assertEquals(2.0, additionOfInchAndInch, 0.1);
        }
        catch (QuantityMeasurementException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void givenOneTonneAnd1000Gram_WhenAdd_ShouldReturn1001Kilogram()
    {
        try
        {
            QuantityMeasurement tone = new QuantityMeasurement(1.0, WeightUnits.TONNE);
            QuantityMeasurement kiloGram = new QuantityMeasurement(1000.0, WeightUnits.GRAM);
            Double additionOfInchAndInch = tone.additionOfTwoUnits(kiloGram);
            Assert.assertEquals(1001.0, additionOfInchAndInch, 0.0);
        }
        catch (QuantityMeasurementException e)
        {
        }
    }

    @Test
    public void Given1FEETAnd1FEETShouldReturnTrue() throws QuantityMeasurementException {
        QuantityMeasurementController measurementController = new QuantityMeasurementController();

        QuantityMeasurementModel measurementModel = new QuantityMeasurementModel(1.0,1.0, "LengthUnits.FEET","LengthUnits.FEET");
        boolean compare = measurementController.compare(measurementModel);
        Assert.assertTrue(compare);
    }

}
