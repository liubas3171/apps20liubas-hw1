package ua.edu.ucu.tempseries;


public final class TempSummaryStatistics {
    public final double avgTemp;
    public final double devTemp;
    public final double minTemp;
    public final double maxTemp;


    public TempSummaryStatistics(double avg, double dev,
                                 double min, double max) {
        avgTemp = avg;
        devTemp = dev;
        minTemp = min;
        maxTemp = max;
    }
}
