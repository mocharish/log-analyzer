package services;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import java.io.*;
import java.net.InetAddress;

public class GeoIP implements IGeoIP {
    private final DatabaseReader geoIpReader;

    public GeoIP(String geoDbPath) throws IOException {
        
        this.geoIpReader = new DatabaseReader.Builder(new File(geoDbPath)).build();
    }

    @Override
    public String getCountryFromIp(String ip) {
        try {
            InetAddress ipAddress = InetAddress.getByName(ip);
            CountryResponse response = geoIpReader.country(ipAddress);
            return response.getCountry().getName();
        } catch (IOException | GeoIp2Exception e) {
            return "Unknown";
        }
    }
}
