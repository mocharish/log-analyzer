import parsers.ILogParser;
import parsers.LogParser;
import services.IGeoIP;
import services.GeoIP;
import services.IUserAgent;
import services.UserAgent;
import analytics.AnalyticsProcessor;
import models.LogEntry;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LogAnalyzer {
    private final ILogParser logParser;
    private final IGeoIP geoIP;
    private final IUserAgent userAgent;
    private final AnalyticsProcessor analyticsProcessor;
     private int totalLogs = 0;

    public LogAnalyzer(ILogParser logParser, IGeoIP geoIP, IUserAgent userAgent) {
        this.logParser = logParser;
        this.geoIP = geoIP;
        this.userAgent = userAgent;
        // Pass the required services to the AnalyticsProcessor
        this.analyticsProcessor = new AnalyticsProcessor(geoIP, userAgent);
    }

    public void processLogFile(String logFilePath) throws IOException {
        File logFile = new File(logFilePath);
        if (!logFile.exists()) {
            System.out.println("Log file does not exist at path: " + logFilePath);
            return;
        }

          try (var lines = Files.lines(Paths.get(logFilePath))) {
        lines.forEach(this::processLogLine);
    }
    }

    private void processLogLine(String line) {
        LogEntry entry = logParser.parseLogLine(line);
        if (entry != null) {
            String country = geoIP.getCountryFromIp(entry.getIp());
            String os = userAgent.getOsFromUserAgent(entry.getUserAgent());
            String browser = userAgent.getBrowserFromUserAgent(entry.getUserAgent());
            totalLogs++;

            // Debug print statements
            // System.out.println("Country: " + country);
            // System.out.println("OS: " + os);
            // System.out.println("Browser: " + browser);

            analyticsProcessor.processEntry(country, os, browser);
        }
    }

    public void printResults() {
        analyticsProcessor.printResults(totalLogs);
    }

    public static void main(String[] args) {
        try {
            String geoDbPath = "GeoLite2-Country.mmdb";
            String logFilePath = "C:\\Users\\Mo\\Documents\\LogAnalyzer_Backend\\all.log";

            ILogParser logParser = new LogParser();
            IGeoIP geoIP = new GeoIP(geoDbPath);
            IUserAgent userAgent = new UserAgent();

            LogAnalyzer analyzer = new LogAnalyzer(logParser, geoIP, userAgent);
            analyzer.processLogFile(logFilePath);
            analyzer.printResults();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
