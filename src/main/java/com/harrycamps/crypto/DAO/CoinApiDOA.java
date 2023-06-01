package com.harrycamps.crypto.DAO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.harrycamps.crypto.Model.ApiResponsePrice;
import com.harrycamps.crypto.Model.ApiResponseSearch;
import com.harrycamps.crypto.Model.ApiResponseTop8Coins;
import okhttp3.*;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
public class CoinApiDOA {

    private static final String BASEURL = "https://api.coinranking.com/v2/";
    private static final String APIKEY = "coinranking74f66a7004b02e4b31c36c97a2fd3130f4a2d33268de2b72";
    private static final String HOSTNAME = "harryezpc@gmail.com";

    /**
     * Makes a GET request to the CoinRanking API with the specified API query.
     *
     * @param apiQuery the API query
     * @return the response body as a string
     * @throws IOException if an I/O error occurs during the request
     */
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

            if (!response.isSuccessful()) {
                return responseBodyString;
            }

            ResponseBody responseBody = response.body();
            responseBodyString = responseBody.string();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return responseBodyString;
    }

    /**
     * Searches for coins based on the specified coin name.
     *
     * @param coinName the coin name to search for
     * @return the response body as a string
     * @throws IOException if an I/O error occurs during the request
     */
    public String searchForCoins(String coinName) throws IOException {
        String query = "search-suggestions?query=" + coinName;
        String responseString = this.getRequest(query);
        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponseSearch apiResponse = objectMapper.readValue(responseString, ApiResponseSearch.class);
        List<ApiResponseSearch.Data.Coin> coins = apiResponse.getData().getCoins();

        return responseString;
    }

    /**
     * Retrieves the top 8 coins from the CoinRanking API.
     *
     * @return the response body as a string
     * @throws IOException if an I/O error occurs during the request
     */
    public String getTop8Coins() throws IOException {
        String query = "search-suggestions";
        String responseString = this.getRequest(query);
        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponseTop8Coins apiResponse = objectMapper.readValue(responseString, ApiResponseTop8Coins.class);

        return responseString;
    }

    /**
     * Retrieves the price of a coin based on its UUID.
     *
     * @param uuid the UUID of the coin
     * @return the price of the coin
     * @throws IOException          if an I/O error occurs during the request
     * @throws InterruptedException if the thread is interrupted during the request
     */
    public double getPrice(String uuid) throws IOException, InterruptedException {
        double price = -1;
        String query = "coin/" + uuid + "/price";
        String responseString = this.getRequest(query);

        if (responseString.isEmpty()) {
            return price;
        }

        ObjectMapper objectMapper = new ObjectMapper();
        ApiResponsePrice apiResponsePrice = objectMapper.readValue(responseString, ApiResponsePrice.class);
        price = Double.parseDouble(apiResponsePrice.getData().getPrice());

        // Add a delay of .5 second
        Thread.sleep(500);

        return price;
    }

}
