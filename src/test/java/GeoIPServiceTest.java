package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeoIPServiceTest {
    private IGeoIPService geoIPService;

    @BeforeEach
    void setUp() throws Exception {
        geoIPService = new GeoIPService("GeoLite2-Country.mmdb");
    }

    @Test
    void testGetCountryFromIp_ValidIp() {
        String country = geoIPService.getCountryFromIp("82.166.148.154");
        assertEquals("Israel", country);  // Assuming 8.8.8.8 is from the US
    }

    @Test
    void testGetCountryFromIp_InvalidIp() {
        String country = geoIPService.getCountryFromIp("invalid_ip");
        assertEquals("Unknown", country);
    }
}
