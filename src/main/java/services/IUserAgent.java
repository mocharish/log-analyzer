package services;

public interface IUserAgent {
    String getOsFromUserAgent(String userAgent);
    String getBrowserFromUserAgent(String userAgent);
}
