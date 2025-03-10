package parsers;

import models.LogEntry;
import java.util.regex.*;

public class LogParser implements ILogParser {
    private static final String LOG_PATTERN = 
        "^(\\S+) - - \\[.*?\\] .*?\".*?\" \\d+ \\d+ .*?\".*?\" \"(.*?)\".*$";
    private static final Pattern pattern = Pattern.compile(LOG_PATTERN);

    @Override
    public LogEntry parseLogLine(String line) {
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return new LogEntry(matcher.group(1), matcher.group(2));
        }
        return null;
    } 
}
