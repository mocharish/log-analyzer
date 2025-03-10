package analytics;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StatsCollector {
    private final Map<String, Integer> stats = new HashMap<>();
    private int totalCount = 0;
    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    public void add(String key) {
        stats.put(key, stats.getOrDefault(key, 0) + 1);
        
    }

    public void printSortedStats(String title, int totalLogs) {
        System.out.println("=== " + title + " ===");
        stats.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Sort descending
            .forEach(entry -> {
                double percentage = (entry.getValue() * 100.0) / totalLogs;
                System.out.println(entry.getKey() + " - "  + DECIMAL_FORMAT.format(percentage) + "%");
            });
        System.out.println();
    }
}
