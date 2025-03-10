package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAgentServiceTest {
    private IUserAgentService userAgentService;

    @BeforeEach
    void setUp() {
        userAgentService = new UserAgentService();
    }

    @Test
    void testGetOsFromUserAgent() {
        String os = userAgentService.getOsFromUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36");
        assertEquals("Windows", os);
    }

    @Test
    void testGetBrowserFromUserAgent() {
        String browser = userAgentService.getBrowserFromUserAgent("Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.1; Trident/6.0)");
        assertEquals("IE", browser);
    }
}
