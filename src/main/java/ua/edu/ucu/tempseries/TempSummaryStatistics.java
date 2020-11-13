package ua.edu.ucu.tempseries;


public final class TempSummaryStatistics {
    final public double avgTemp;
    final public  double devTemp;
    final public double minTemp;
    final public double maxTemp;


    public TempSummaryStatistics(double avg, double dev,
                                 double min, double max) {
        this.avgTemp = avg;
        this.devTemp = dev;
        this.minTemp = min;
        this.maxTemp = max;
    }
}
