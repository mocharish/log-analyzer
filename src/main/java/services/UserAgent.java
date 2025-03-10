package services;

import ua_parser.Client;
import ua_parser.Parser;

public class UserAgent implements IUserAgent {
    private final Parser uaParser;

    public UserAgent() {
        this.uaParser = new Parser();
    }

    @Override
    public String getOsFromUserAgent(String userAgent) {
        Client client = uaParser.parse(userAgent);
        return client.os.family;
    }

    @Override
    public String getBrowserFromUserAgent(String userAgent) {
        Client client = uaParser.parse(userAgent);
        return client.userAgent.family;
    }
}
