package parsers;

import models.LogEntry;

public interface ILogParser {
    LogEntry parseLogLine(String line);
}
