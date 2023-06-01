package com.harrycamps.crypto.DAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harrycamps.crypto.Model.ApiResponseSearch;
import com.harrycamps.crypto.Model.ApiResponseTop8Coins;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CoinApiDOA {

    private static final String BASEURL = "https://api.coinranking.com/v2/";
    private static final String APIKEY = "coinranking8f4e02ca64e308c673d27c12d8304b5547c3a44bba7756ab";
    private static final String HOSTNAME = "harrycamps@me.com";
    //                .url("https://api.coinranking.com/v2/search-suggestions?query=bitcoin")
    //                .url("https://api.coinranking.com/v2/search-suggestions")

    private String getRequest(String apiQuery) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String responseBodyString = "";

        try {
            Request request = new Request.Builder()
                    .url(this.BASEURL + apiQuery)
                    .get()
                    .addHeader("X-RapidAPI-Key", this.APIKEY)
                    .addHeader("X-RapidAPI-Host", this.HOSTNAME)

                    .build();
            Response response = client.newCall(request).execute();
            ResponseBody responseBody = response.body();
            responseBodyString = responseBody.string();


        } catch( IOException e ){
            e.printStackTrace();
        }

        return responseBodyString;
    }

    public String searchForCoins(String coinName) throws IOException {
        String query = "search-suggestions?query=" + coinName;
        String responseString = this.getRequest(query);
        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponseSearch apiResponse = objectMapper.readValue(responseString, ApiResponseSearch.class);
        List<ApiResponseSearch.Data.Coin> coins = apiResponse.getData().getCoins();
        for (ApiResponseSearch.Data.Coin coin : coins) {
            System.out.println(coin);
            System.out.println("------------");
        }
        return responseString;
    }

    public String getTop8Coins() throws IOException {
        String query = "search-suggestions";
        String responseString = this.getRequest(query);
        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponseTop8Coins apiResponse = objectMapper.readValue(responseString, ApiResponseTop8Coins.class);
        List<ApiResponseTop8Coins.Coin> coins = apiResponse.getData().getCoins();
        for (ApiResponseTop8Coins.Coin coin : coins) {
            System.out.println(coin);
            System.out.println("------------");
        }
        return responseString;
    }

    public String getPrice(String uuid) throws IOException {
        String query = "coin/" + uuid + "/price";
        String responseString = this.getRequest(query);
        System.out.println(responseString);
        return responseString;
    }

}
