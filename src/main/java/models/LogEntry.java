package models;

public class LogEntry {
    private final String ip;
    private final String userAgent;

    public LogEntry(String ip, String userAgent) {
        this.ip = ip;
        this.userAgent = userAgent;
    }

    public String getIp() {
        return ip;
    }

    public String getUserAgent() {
        return userAgent;
    }
}
