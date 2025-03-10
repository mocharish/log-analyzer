# LogAnalyzer Backend

## Overview
LogAnalyzer is a backend application designed to process and analyze log files. It extracts useful information such as user locations and browser details from log data, leveraging third-party libraries for geo-location and user-agent parsing.

## Features
- Parses log files and extracts relevant information.
- Determines the geographical location of users based on IP addresses.
- Identifies browser and device details from user-agent strings.
- Provides structured insights into log data.
- Includes unit tests for core functions.

## Technologies Used
- **Java**
- **Gradle** (Build Automation)
- **JUnit** (Testing Framework)
- **MaxMind GeoIP2** (Geo-location Service)
- **UA-Parser Java** (User-Agent Parsing)


## Installation

- Java
- Gradle installed (`gradle -v` to check)


### Setup Steps

- Clone the repository:
```sh
git clone https://github.com/mocharish/log-analyzer.git
cd log-analyzer
```

- Build the project:
   ```sh
   gradle build
   ```
- Run the application:
   ```sh
   gradle run
   ```

## Output Format

### Top Countries
```
United States: 33516 (85.61%)
Brazil: 1140 (2.91%)
Kazakhstan: 509 (1.30%)
Indonesia: 371 (0.95%)
Japan: 292 (0.75%)
France: 285 (0.73%)
The Netherlands: 282 (0.72%)
China: 267 (0.68%)
United Kingdom: 233 (0.60%)
Colombia: 208 (0.53%)
```

### Top Browsers
```
IE: 30432 (77.74%)
Firefox: 2534 (6.47%)
Chrome: 1718 (4.39%)
Other: 772 (1.97%)
Safari: 676 (1.73%)
Mobile Safari: 545 (1.39%)
Opera: 464 (1.19%)
```

### Top Operating Systems
```
Windows: 34862 (89.05%)
Other: 1506 (3.85%)
Mac OS X: 1042 (2.66%)
iOS: 685 (1.75%)
Android: 460 (1.18%)
Linux: 219 (0.56%)
Ubuntu: 76 (0.19%)
Nokia Series 40: 53 (0.14%)
Chrome OS: 34 (0.09%)
Fedora: 32 (0.08%)
```



## Configuration
- **GeoIP Database:**
  - Download `GeoLite2-Country.mmdb` from [MaxMind](https://dev.maxmind.com/geoip/geolite2-free-geolocation-data)
 

## Running Tests
Run all tests with:
```sh
gradle test
```

You can find test results in build/reports/tests folder.




