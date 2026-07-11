package com.CryptoTracker.demo.CryptoService;

import com.CryptoTracker.demo.models.CryptoCoin;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class CryptoService {

    private static final String API_URL =
            "https://api.coingecko.com/api/v3/simple/price?ids=%s&vs_currencies=usd&include_24hr_change=true";

    public List<CryptoCoin> getCryptoprices(List<String> coins) {
        List<CryptoCoin> coinList = new ArrayList<>();

        // Build API URL
        String ids = String.join(",", coins);
        String url = String.format(API_URL, ids);

        // Call API
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        System.out.println("CoinGecko API Response: " + response);

        // Parse JSON response
        JSONObject json = new JSONObject(response);

        for (String coin : coins) {
            String id = coin.toLowerCase();
            if (json.has(id)) {
                JSONObject coinJson = json.getJSONObject(id);
                double price = coinJson.getDouble("usd");
                double change24h = coinJson.getDouble("usd_24h_change");

                // Add to list
                coinList.add(new CryptoCoin(id , price, change24h));
            }
        }

        return coinList;
    }
}

