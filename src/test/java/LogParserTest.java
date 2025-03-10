package parsers;

import models.LogEntry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogParserTest {
    private ILogParser logParser;

    @BeforeEach
    void setUp() {
        logParser = new LogParser();
    }

    @Test
    void testParseLogLine_ValidLog() {
        String logLine = "82.166.148.154 - - [20/Jan/2013:06:56:32 -0600] " +
                "\"GET /wp-content/themes/twentytwelve/js/navigation.js?ver=1.0 HTTP/1.1\" 200 863 " +
                "\"http://creditcardandloanoffers.com/?utm_source=Contextin&utm_term=_\" " +
                "\"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:15.0) Gecko/20100101 Firefox/15.0.1\" 361 1133 - 5625";

        LogEntry entry = logParser.parseLogLine(logLine);

        assertNotNull(entry);
        assertEquals("82.166.148.154", entry.getIp()); // Corrected expected IP
        assertEquals("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:15.0) Gecko/20100101 Firefox/15.0.1", entry.getUserAgent()); // Fixed expected user-agent
    }

    @Test
    void testParseLogLine_InvalidLog() {
        String logLine = "Invalid log line";
        LogEntry entry = logParser.parseLogLine(logLine);

        assertNull(entry);
    }
}
