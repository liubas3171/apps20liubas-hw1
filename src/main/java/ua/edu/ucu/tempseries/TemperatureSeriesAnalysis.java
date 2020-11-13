package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {
    private double[] array = new double[1];
    private final double absMin = -273;
    private double maxVal = absMin;
    private double minVal = Double.POSITIVE_INFINITY;
    private int realCapacity = 0;

    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        processingArray(temperatureSeries);
    }

    public double average() {
        checkIfEmpty();

        double res = 0;
        for (int i = 0; i < realCapacity; i++) {
            res += array[i];
        }
        res = res / realCapacity;
        return res;
    }

    public double deviation() {
        checkIfEmpty();

        double expectanceOfSquared = 0;
        for (int i = 0; i < realCapacity; i++) {
            expectanceOfSquared += array[i] * array[i];
        }
        expectanceOfSquared /= realCapacity;
        double squaredExpectance = average();
        squaredExpectance *= squaredExpectance;
        double variance = expectanceOfSquared - squaredExpectance;
        return Math.sqrt(variance);
    }

    public double min() {
        checkIfEmpty();
        return minVal;
    }

    public double max() {
        checkIfEmpty();
        return maxVal;
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        checkIfEmpty();

        double res = array[0];
        double dist = Math.abs(tempValue - array[0]);
        for (int i = 0; i < realCapacity; i++) {
            double newDist = Math.abs(tempValue - array[i]);
            if (newDist < dist) {
                res = array[i];
                dist = newDist;
            } else if (newDist == dist) {
                if (array[i] > res) {
                    res = array[i];
                }
            }
        }
        return res;
    }

    public double[] findTempsLessThen(double tempValue) {
        int sizeOfNewArray = 0;
        for (int i = 0; i < realCapacity; i++) {
            if (array[i] < tempValue) {
                sizeOfNewArray++;
            }
        }
        double[] resArray = new double[sizeOfNewArray];
        int pointer = 0;
        for (int i = 0; i < realCapacity; i++) {
            if (array[i] < tempValue) {
                resArray[pointer] = array[i];
                pointer++;
            }
        }
        return resArray;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        int sizeOfNewArray = 0;
        for (int i = 0; i < realCapacity; i++) {
            if (array[i] >= tempValue) {
                sizeOfNewArray++;
            }
        }
        double[] resArray = new double[sizeOfNewArray];
        int pointer = 0;
        for (int i = 0; i < realCapacity; i++) {
            if (array[i] >= tempValue) {
                resArray[pointer] = array[i];
                pointer++;
            }
        }
        return resArray;
    }

    public TempSummaryStatistics summaryStatistics() {
        double avgTemp = average();
        double devTemp = deviation();
        double minTemp = min();
        double maxTemp = max();
        return new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
    }

    public int addTemps(double... temps) {
        processingArray(temps);
        return realCapacity;
    }

    private void checkIfEmpty() {
        if (realCapacity == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void doubleCapacityOfArray() {
        double[] res = new double[array.length * 2];
        System.arraycopy(array, 0, res, 0, array.length);
        array = res;
    }

    private void processingArray(double[] values) {
        if (values.length == 0) {
            return;
        }
        double localMaxVal = values[0];
        double localMinVal = values[0];

        for (double value : values) {
            if (value < absMin) {
                throw new InputMismatchException();
            } else if (value < localMinVal) {
                localMinVal = value;
            } else if (value > localMaxVal) {
                localMaxVal = value;
            }
        }
        if (localMaxVal > maxVal) {
            maxVal = localMaxVal;
        }
        if (localMinVal < minVal) {
            minVal = localMinVal;
        }

        for (double value : values) {
            if (realCapacity >= array.length) {
                doubleCapacityOfArray();
            }
            array[realCapacity] = value;
            realCapacity += 1;
        }
    }
}
