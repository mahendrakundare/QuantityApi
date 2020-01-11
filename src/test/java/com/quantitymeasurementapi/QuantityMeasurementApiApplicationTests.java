package com.quantitymeasurementapi;

import com.quantitymeasurementapi.exception.QuantityMeasurementException;
import com.quantitymeasurementapi.service.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class QuantityMeasurementApiApplicationTests {
    @Test
    public void forOneFeetAndAnotherOneFeet_ShouldReturnEqual()
    {
        QuantityMeasurement feet1 = new QuantityMeasurement(1.0, UnitOfLength.FEET);
        QuantityMeasurement feet2 = new QuantityMeasurement(1.0, UnitOfLength.FEET);
        Assert.assertEquals(feet2, feet1);
    }

    @Test
    public void givenOneFeetAndAnotherFeet_ShouldReturnNotEqual()
    {
        QuantityMeasurement feet1 = new QuantityMeasurement(1.0, UnitOfLength.FEET);
        QuantityMeasurement feet2 = new QuantityMeasurement(2.0, UnitOfLength.FEET);
        Assert.assertNotEquals(feet1, feet2);
    }

    @Test
    public void givenOneInchAndAnotherOneInch_ShouldReturnEqual()
    {
        QuantityMeasurement inch1 = new QuantityMeasurement(0.0, UnitOfLength.INCH);
        QuantityMeasurement inch2 = new QuantityMeasurement(0.0, UnitOfLength.INCH);
        Assert.assertEquals(inch1, inch2);
    }

    @Test
    public void givenZeroInchAndAnotherOneInch_ShouldReturnNotEqual()
    {
        QuantityMeasurement inch1 = new QuantityMeasurement(0.0, UnitOfLength.INCH);
        QuantityMeasurement inch2 = new QuantityMeasurement(2.0, UnitOfLength.INCH);
        Assert.assertNotEquals(inch1, inch2);
    }

    @Test
    public void givenOneFeetAndOneInch_ShouldReturnNotEqual()
    {
        QuantityMeasurement inch1 = new QuantityMeasurement(1.0, UnitOfLength.FEET);
        QuantityMeasurement feet1 = new QuantityMeasurement(1.0, UnitOfLength.INCH);
        Assert.assertNotEquals(inch1, feet1);
    }

    @Test
    public void comparingZeroInchAndZeroFeet_ShouldReturnEqualLength()
    {
        try
        {
            QuantityMeasurement inch1 = new QuantityMeasurement(0.0, UnitOfLength.FEET);
            QuantityMeasurement feet1 = new QuantityMeasurement(0.0, UnitOfLength.INCH);
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
            QuantityMeasurement inch1 = new QuantityMeasurement(1.0, UnitOfLength.FEET);
            QuantityMeasurement feet1 = new QuantityMeasurement(1.0, UnitOfLength.INCH);
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
            QuantityMeasurement inch1 = new QuantityMeasurement(1.0, UnitOfLength.INCH);
            QuantityMeasurement feet1 = new QuantityMeasurement(1.0, UnitOfLength.INCH);
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
            QuantityMeasurement inch1 = new QuantityMeasurement(1.0, UnitOfLength.INCH);
            QuantityMeasurement feet1 = new QuantityMeasurement(1.0, UnitOfLength.INCH);
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
            QuantityMeasurement inch1 = new QuantityMeasurement(1.0, UnitOfLength.INCH);
            QuantityMeasurement feet1 = new QuantityMeasurement(1.0, UnitOfLength.FEET);
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
            QuantityMeasurement inch1 = new QuantityMeasurement(1.0, UnitOfLength.INCH);
            QuantityMeasurement feet1 = new QuantityMeasurement(1.0, UnitOfLength.INCH);
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
            QuantityMeasurement inch1 = new QuantityMeasurement(1.0, UnitOfLength.YARD);
            QuantityMeasurement feet1 = new QuantityMeasurement(1.0, UnitOfLength.YARD);
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
            QuantityMeasurement inch1 = new QuantityMeasurement(1.0, UnitOfLength.INCH);
            QuantityMeasurement yard1 = new QuantityMeasurement(1.0, UnitOfLength.YARD);
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
            QuantityMeasurement inch1 = new QuantityMeasurement(36.0, UnitOfLength.INCH);
            QuantityMeasurement yard1 = new QuantityMeasurement(1.0, UnitOfLength.YARD);
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
            QuantityMeasurement inch1 = new QuantityMeasurement(3.0, UnitOfLength.FEET);
            QuantityMeasurement yard1 = new QuantityMeasurement(1.0, UnitOfLength.YARD);
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
            QuantityMeasurement feet1 = new QuantityMeasurement(1.0, UnitOfLength.FEET);
            QuantityMeasurement yard1 = new QuantityMeasurement(3.0, UnitOfLength.YARD);
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
            QuantityMeasurement inch = new QuantityMeasurement(2.0, UnitOfLength.INCH);
            QuantityMeasurement centiMeter = new QuantityMeasurement(5.0, UnitOfLength.CENTI_METER);
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
            QuantityMeasurement gallon = new QuantityMeasurement(1.0, UnitOfVolume.GALLON);
            QuantityMeasurement litre = new QuantityMeasurement(3.78, UnitOfLength.INCH);
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
            QuantityMeasurement gallon = new QuantityMeasurement(1.0, UnitOfVolume.GALLON);
            QuantityMeasurement litre = new QuantityMeasurement(3.78, UnitOfVolume.LITRE);
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
            QuantityMeasurement litre = new QuantityMeasurement(1.0, UnitOfVolume.LITRE);
            QuantityMeasurement milliLitre = new QuantityMeasurement(1000.0, UnitOfVolume.MILLI_LITRE);
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
            QuantityMeasurement litre = new QuantityMeasurement(1.0, UnitOfWeights.KILOGRAM);
            QuantityMeasurement milliLitre = new QuantityMeasurement(1000.0, UnitOfWeights.GRAM);
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
            QuantityMeasurement litre = new QuantityMeasurement(1.0, UnitOfWeights.TONNE);
            QuantityMeasurement milliLitre = new QuantityMeasurement(1000.0, UnitOfWeights.KILOGRAM);
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
            QuantityMeasurement fahrenheit = new QuantityMeasurement(212.0, UnitOfTemperature.FAHRENHEIT);
            QuantityMeasurement celsius = new QuantityMeasurement(100.0, UnitOfTemperature.CELSIUS);
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
            QuantityMeasurement inch2 = new QuantityMeasurement(2.0, UnitOfLength.INCH);
            QuantityMeasurement inch1 = new QuantityMeasurement(2.0, UnitOfLength.INCH);
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
            QuantityMeasurement oneFeet1 = new QuantityMeasurement(1.0, UnitOfLength.FEET);
            QuantityMeasurement oneFeet2 = new QuantityMeasurement(1.0, UnitOfLength.FEET);
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
            QuantityMeasurement oneFeet = new QuantityMeasurement(1.0, UnitOfLength.FEET);
            QuantityMeasurement oneInch = new QuantityMeasurement(2.0, UnitOfLength.INCH);
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
            QuantityMeasurement twoInch = new QuantityMeasurement(2.0, UnitOfLength.INCH);
            QuantityMeasurement twoPointFiveCM = new QuantityMeasurement(2.5, UnitOfLength.CENTI_METER);
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
            QuantityMeasurement twoInch = new QuantityMeasurement(1.0, UnitOfVolume.GALLON);
            QuantityMeasurement twoPointFiveCM = new QuantityMeasurement(3.78, UnitOfVolume.LITRE);
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
            QuantityMeasurement twoInch = new QuantityMeasurement(1000.0, UnitOfVolume.MILLI_LITRE);
            QuantityMeasurement twoPointFiveCM = new QuantityMeasurement(1.0, UnitOfVolume.LITRE);
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
            QuantityMeasurement tone = new QuantityMeasurement(1.0, UnitOfWeights.TONNE);
            QuantityMeasurement kiloGram = new QuantityMeasurement(1000.0, UnitOfWeights.GRAM);
            Double additionOfInchAndInch = tone.additionOfTwoUnits(kiloGram);
            Assert.assertEquals(1001.0, additionOfInchAndInch, 0.0);
        }
        catch (QuantityMeasurementException e)
        {
        }
    }

}
