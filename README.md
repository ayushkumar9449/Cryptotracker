# CryptoTracker

A Spring Boot web app that fetches live cryptocurrency prices and 24-hour price changes from the [CoinGecko API](https://www.coingecko.com/en/api). Enter one or more coin IDs and view formatted results in a simple, dark-themed UI.

## Features

- Live crypto prices in USD
- 24-hour percentage change per coin
- Simple web form — no API key required
- Thymeleaf templates with a responsive dark UI
- REST integration with CoinGecko's public API

## Tech Stack

- **Java 17**
- **Spring Boot 4.1**
- **Spring Web MVC**
- **Thymeleaf**
- **Maven**

## Prerequisites

- Java 17 or later
- Maven 3.6+ (or use the included Maven Wrapper)

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/<your-username>/crypto-tracker.git
cd crypto-tracker
```

### 2. Run the application

**Using Maven Wrapper (recommended):**

```bash
# Windows
.\mvnw.cmd spring-boot:run

# macOS / Linux
./mvnw spring-boot:run
```

**Using Maven directly:**

```bash
mvn spring-boot:run
```

### 3. Open in browser

Go to [http://localhost:9191](http://localhost:9191)

## Usage

1. Open the home page at `/`
2. Enter CoinGecko coin IDs separated by commas  
   Example: `bitcoin, ethereum, solana`
3. Click **Track Prices** to see live USD prices and 24h change

> **Note:** Use CoinGecko **coin IDs**, not ticker symbols.  
> Examples: `bitcoin`, `ethereum`, `solana`, `cardano`, `dogecoin`  
> Full list: [CoinGecko API coin list](https://api.coingecko.com/api/v3/coins/list)

## Project Structure

```
src/
├── main/
│   ├── java/com/CryptoTracker/demo/
│   │   ├── CryptotrackerApplication.java   # Main entry point
│   │   ├── CryptoControl/
│   │   │   └── CryptoController.java       # Web routes
│   │   ├── CryptoService/
│   │   │   └── CryptoService.java          # CoinGecko API integration
│   │   └── models/
│   │       └── CryptoCoin.java             # Data model
│   └── resources/
│       ├── application.properties
│       └── templates/
│           ├── index.html                  # Home page
│           └── result.html                 # Results page
└── test/
    └── java/com/CryptoTracker/demo/
        └── DemoApplicationTests.java
```

## Configuration

| Property | Default | Description |
|----------|---------|-------------|
| `server.port` | `9191` | Port the app runs on |
| `spring.application.name` | `CryptoTracker` | Application name |

Edit `src/main/resources/application.properties` to change the port or other settings.

## API Reference

This app uses the CoinGecko Simple Price endpoint:

```
GET https://api.coingecko.com/api/v3/simple/price?ids={coin_ids}&vs_currencies=usd&include_24hr_change=true
```

CoinGecko's free tier has rate limits. Avoid rapid repeated requests during development.

## Running Tests

```bash
# Windows
.\mvnw.cmd test

# macOS / Linux
./mvnw test
```

## Build JAR

```bash
# Windows
.\mvnw.cmd clean package

# macOS / Linux
./mvnw clean package
```

Run the packaged app:

```bash
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

## Push to GitHub

If you haven't created a remote repository yet:

```bash
# Create a new repo on GitHub, then:
git remote add origin https://github.com/<your-username>/<repo-name>.git
git branch -M main
git push -u origin main
```

## Author

**AYUSh**

## License

This project is licensed under the MIT License — see the [LICENSE](LICENSE) file for details.
