package com.harrycamps.crypto.Service;
import com.harrycamps.crypto.DAO.NewsArticleScraper;
import jakarta.annotation.PostConstruct;
import okhttp3.*;
import org.springframework.stereotype.Service;
//import org.json.JSONObject;

import java.io.IOException;

@Service
public class ApiRetrieve {
    OkHttpClient client = new OkHttpClient();

    //private RequestBody body;
    @PostConstruct
    public void getAPIData() throws IOException{

//        NewsArticleScraper newsArticleScraper = new NewsArticleScraper();
//        // Ethereum, Bitcoin
//        newsArticleScraper.scrapeCoinNews("Ethereum");
//        CoinApiController coinApiController = new CoinApiController();
//        coinApiController.getPrice("Qwsogvtv82FCd");
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://api.coinranking.com/v2/coins")
//                .get()
//                .addHeader("X-RapidAPI-Key", "coinranking8f4e02ca64e308c673d27c12d8304b5547c3a44bba7756ab")
//                .addHeader("X-RapidAPI-Host", "harrycamps@me.com")
////                .url("https://api.coinranking.com/v2/search-suggestions?query=bitcoin")
////                .url("https://api.coinranking.com/v2/search-suggestions")
//                .build();
//        Response response = client.newCall(request).execute();
//        ResponseBody responseBody = response.body();
//        String responseBodyString = responseBody.string();


//        ObjectMapper objectMapper = new ObjectMapper();
//        ApiResponse2 apiResponse2 = objectMapper.readValue(responseBodyString, ApiResponse2.class);
//
//        // Access the data
//        List<ApiResponse2.Coin> coins = apiResponse2.getData().getCoins();
//        List<ApiResponse2.Exchange> exchanges = apiResponse2.getData().getExchanges();
//        List<ApiResponse2.Market> markets = apiResponse2.getData().getMarkets();
//
//        for (ApiResponse2.Coin coin : coins) {
//            System.out.println(coin);
//            System.out.println("------------");
//        }


//        System.out.println(response.isSuccessful());
//        System.out.println(responseBodyString);

//        ObjectMapper objectMapper = new ObjectMapper();
//        ApiResponse apiResponse = objectMapper.readValue(responseBodyString, ApiResponse.class);
//
//        // Access the data
//        List<ApiResponse.Data.Coin> coins = apiResponse.getData().getCoins();
//        List<ApiResponse.Data.Exchange> exchanges = apiResponse.getData().getExchanges();
//        List<ApiResponse.Data.Market> markets = apiResponse.getData().getMarkets();

//        System.out.println("Coins:");
//        for (ApiResponse.Data.Coin coin : coins) {
//            System.out.println(coin);
//            System.out.println("Name: " + coin.getName());
//            System.out.println("Symbol: " + coin.getSymbol());
////            System.out.println("Price: " + coin.getPrice());
//            System.out.println("------------");
//        }

//        System.out.println("Exchanges:");
//        for (ApiResponse.Data.Exchange exchange : exchanges) {
//            System.out.println("Name: " + exchange.getExchangeName());
//            System.out.println("Base Symbol: " + exchange.getBaseSymbol());
//            System.out.println("Quote Symbol: " + exchange.getQuoteSymbol());
//            System.out.println("------------");
//        }
//        System.out.println("Markets:");
//        for (ApiResponse.Data.Market market : markets) {
//            System.out.println(market);
//            System.out.println("Exchange Name: " + market.getExchangeName());
//            System.out.println("Base Symbol: " + market.getBaseSymbol());
//            System.out.println("Quote Symbol: " + market.getQuoteSymbol());
//            System.out.println("------------");
//        }

//        ResponseBody responseBody = response.body();
//        String responseBodyString = responseBody.string();
//        System.out.println(responseBodyString);
//        response.close();
//        Gson gson = new Gson();
//        CryptoAPI entity = gson.fromJson(responseBodyString, CryptoAPI.class);
//        System.out.println(entity.getName());
//
//        ObjectMapper objectMapper = new ObjectMapper();
        // List<CryptoAPI> list = objectMapper.readValue(response. new TypeReference<List<CryptoAPI>>(){});
        // list.forEach(cryptoAPI -> System.out.println(cryptoAPI.getName()));
        // names.forEach(name -> {
        //    System.out.println(name);
        //});





//        int statusCode = response.code();
//        String statusMessage = response.message();
//        System.out.println(responseBody);
//        System.out.println(responseBodyString);
//        System.out.println(statusMessage);

    }

}
