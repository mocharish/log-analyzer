package analytics;

import services.IGeoIP;
import services.IUserAgent;
import models.LogEntry;

public class AnalyticsProcessor {
    private final StatsCollector countryStats = new StatsCollector();
    private final StatsCollector browserStats = new StatsCollector();
    private final StatsCollector osStats = new StatsCollector();
    private final IGeoIP geoIP;
    private final IUserAgent userAgent;
    

    public AnalyticsProcessor(IGeoIP geoIP, IUserAgent userAgent) {
        this.geoIP = geoIP;
        this.userAgent = userAgent;
    }

    public void processEntry(String country, String os, String browser) {
        if (country != null && !"Unknown".equals(country)) {
        countryStats.add(country);
    }

        
        if (browser != null) {
            browserStats.add(browser);
        }
        if (os != null) {
            osStats.add(os);
        }
    }

    public void printResults(int totalLogs) {
        countryStats.printSortedStats("Top Countries", totalLogs);
        browserStats.printSortedStats("Top Browsers", totalLogs);
        osStats.printSortedStats("Top Operating Systems", totalLogs);
    }
}
