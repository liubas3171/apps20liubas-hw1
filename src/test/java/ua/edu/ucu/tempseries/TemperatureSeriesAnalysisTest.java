package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyConstructorEmptyForever() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();
        seriesAnalysis.average();
    }

    @Test
    public void testEmptyConstructorElsAddedLater() {
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis();

        seriesAnalysis.addTemps(1, 3, -5, 8);

        double expRes = -5;
        double actualRes = seriesAnalysis.min();

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        // Exception here
        seriesAnalysis.deviation();
    }

    @Test
    public void testDeviationWithOneEl() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expResult = 0;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testDeviationWithPositiveArray() {
        double[] series = {5, 6, 22, 100, 55};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);
        // Calculated in Excel)
        double expRes = 36.058841;

        double actualRes = obj.deviation();

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testDeviationWithNegativeArray() {
        double[] series = {-2, -6, -222, -100, -155};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);
        // Excel)
        double expRes = 85.210328;

        double actualRes = obj.deviation();

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testDeviationWithDiffEls() {
        double[] series = {-2.5, 0, 3.01};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);
        // Excel)
        double expRes = 2.2526577;

        double actualRes = obj.deviation();

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.min();
    }

    @Test
    public void testMinWithOneEl() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expResult = -1.0;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinNormArray() {
        double[] series = {-2, 6, 22, -100, 55, 2};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double expRes = -100;

        double actualRes = obj.min();

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.max();
    }

    @Test
    public void testMaxWithOneEl() {
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        double expResult = -1.0;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxNormArray() {
        double[] series = {-2, 6, 22, -100, 55, 2};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double expRes = 55;

        double actualRes = obj.max();

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZeroOneEl() {
        double[] series = {-200.3};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double expRes = -200.3;

        double actualRes = obj.findTempClosestToZero();

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroNormArray() {
        double[] series = {-200.3, 22, 0.3, -3, 4};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double expRes = 0.3;

        double actualRes = obj.findTempClosestToZero();

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroEqualByModule() {
        double[] series = {-200.3, 2, 4, -0.6, 7, 0.6};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double expRes = 0.6;

        double actualRes = obj.findTempClosestToZero();

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        seriesAnalysis.findTempClosestToValue(333);
    }

    @Test
    public void testFindTempClosestToValueOneEl() {
        double[] series = {0.6};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double expRes = 0.6;

        double actualRes = obj.findTempClosestToValue(5000);

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueEqualByModule() {
        double[] series = {-200.3, 2, 4, -0.6, 7, 0.6, 8.5, 11.5};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double expRes = 11.5;

        double actualRes = obj.findTempClosestToValue(10);

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueNormArray() {
        double[] series = {-200.3, 2, 4, -0.6, 7, 0.6};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double expRes = -0.6;

        double actualRes = obj.findTempClosestToValue(-10);

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testFindTempsLessThenWithNoLessEls() {
        double[] series = {0.6, 3};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double[] expRes = new double[0];

        double[] actualRes = obj.findTempsLessThen(-4);

        assertArrayEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testFindTempsLessThenWithNoEls() {
        double[] series = {};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double[] expRes = new double[0];

        double[] actualRes = obj.findTempsLessThen(-4);

        assertArrayEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testFindTempsLessThenWithEqualEl() {
        double[] series = {0.6, 3, -4, -10};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double[] expRes = {-10};

        double[] actualRes = obj.findTempsLessThen(-4);

        assertArrayEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testFindTempsLessThenWithNormArray() {
        double[] series = {0.6, 3, -9, 12, 2, -4.0001, -18};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double[] expRes = {-9, -4.0001, -18};

        double[] actualRes = obj.findTempsLessThen(-4);

        assertArrayEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testFindTempsLessThenWithSameEls() {
        double[] series = {0.6, 3, -9, 12, 2, -4.0001, -18, -18};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double[] expRes = {-9, -4.0001, -18, -18};

        double[] actualRes = obj.findTempsLessThen(-4);

        assertArrayEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testTempsGreaterThenWithNoGreaterEls() {
        double[] series = {2, 6, 0.1, 3.33, 0};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double[] expRes = new double[0];

        double[] actualRes = obj.findTempsGreaterThen(9);

        assertArrayEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testTempsGreaterThenWithNoEls() {
        double[] series = {};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double[] expRes = new double[0];

        double[] actualRes = obj.findTempsGreaterThen(9);

        assertArrayEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testTempsGreaterThenWithEqualEl() {
        double[] series = {9.4, 2, 6, 0.1, 3.33, 0, 9, 22};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double[] expRes = {9.4, 9, 22};

        double[] actualRes = obj.findTempsGreaterThen(9);

        assertArrayEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testTempsGreaterThenWithSameEls() {
        double[] series = {10, 2, 6, 9, 0.1, 3.33, 0, 10, 55, 9};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double[] expRes = {10, 9, 10, 55, 9};

        double[] actualRes = obj.findTempsGreaterThen(9);

        assertArrayEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testTempsGreaterThenWithNormArray() {
        double[] series = {10, 2, 6, 0.1, 3.33, 0, 28, -33, 90};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        double[] expRes = {10, 28, 90};

        double[] actualRes = obj.findTempsGreaterThen(9);

        assertArrayEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testAddTempsBothEmpty() {
        double[] series = {};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        int expRes = 0;

        int actualRes = obj.addTemps();

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testAddTempsNewElsEmpty() {
        double[] series = {1, 4, 6};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        int expRes = 3;

        int actualRes = obj.addTemps();

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testAddTempsOldElsEmpty() {
        double[] series = {};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        int expRes = 4;

        int actualRes = obj.addTemps(2, 3, 7, -8);

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testAddTempsBothElsAre() {
        double[] series = {0, 4, 4, 2};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        int expRes = 7;

        int actualRes = obj.addTemps(-6, 3, 2);

        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTempsWithLessThanAbsolute() {
        double[] series = {0, 4, 4, 2};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);
        // Exception here
        obj.addTemps(-6, 3, 2, -300);
    }

    @Test
    public void testAddMethodMin() {
        double[] series = {0, 4, 4, 2, 7, -8, 15, 1, -12};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        obj.addTemps(-40, 33, 22);

        double expResMin = -40;
        double actualResMin = obj.min();
        assertEquals(expResMin, actualResMin, 0.00001);
    }

    @Test
    public void testAddMethodMax() {
        double[] series = {0, 4, 4, 2, 7, -8, 15, 1, -12};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        obj.addTemps(-40, 33, 22);

        double expResMax = 33;
        double actualResMax = obj.max();
        assertEquals(expResMax, actualResMax, 0.00001);
    }

    @Test
    public void testAddMethodDeviation() {
        double[] series = {0, 4, 4, 2, 7, -8, 15, 1, -12};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        obj.addTemps(-40, 33, 22);

        double expRes = 17.38453975;
        double actualRes = obj.deviation();
        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testAddMethodAverage() {
        double[] series = {0, 4, 4, 2, 7, -8, 15, 1, -12};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        obj.addTemps(-40, 33, 22);

        double expRes = 2.3333333;
        double actualRes = obj.average();
        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testAddMethodClosestToValue() {
        double[] series = {0, 4, 4, 2, 7, -8, 15, 1, -12};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        obj.addTemps(-40, 33, 22);

        double expRes = -40;
        double actualRes = obj.findTempClosestToValue(-38);
        assertEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testAddMethodTempsLessThan() {
        double[] series = {0, 4, 4, 2, 7, -8, 15, 1, -12};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        obj.addTemps(-40, 33, 22);

        double[] expRes = {0, 2, -8, 1, -12, -40};
        double[] actualRes = obj.findTempsLessThen(4);
        assertArrayEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testAddMethodTempsGreaterThan() {
        double[] series = {0, 4, 4, 2, 7, -8, 15, 1, -12};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        obj.addTemps(-40, 33, 22);

        double[] expRes = {4, 4, 7, 15, 33, 22};
        double[] actualRes = obj.findTempsGreaterThen(4);
        assertArrayEquals(expRes, actualRes, 0.00001);
    }

    @Test
    public void testSummaryStatisticsNormValues() {
        double[] series = {0, 4, 4, 2, 7, -8, 15, 1, -12};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        TempSummaryStatistics stat = obj.summaryStatistics();

        double expResMin = -12;
        double actualResMin = stat.minTemp;
        assertEquals(expResMin, actualResMin, 0.00001);

        double expResMax = 15;
        double actualResMax = stat.maxTemp;
        assertEquals(expResMax, actualResMax, 0.00001);

        double expResAvg = 1.444444;
        double actualResAvg = stat.avgTemp;
        assertEquals(expResAvg, actualResAvg, 0.00001);

        double expResDev = 7.455216088;
        double actualResDev = stat.devTemp;
        assertEquals(expResDev, actualResDev, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsNoValues() {
        double[] series = {};
        TemperatureSeriesAnalysis obj = new TemperatureSeriesAnalysis(series);

        TempSummaryStatistics stat = obj.summaryStatistics();

    }
}
