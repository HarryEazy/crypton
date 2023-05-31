package com.harrycamps.crypto.Model;

import java.util.List;

public class ApiResponseSearch {
    private String status;
    private Data data;

    // Getters and setters


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private List<Coin> coins;
        private List<Exchange> exchanges;
        private List<Market> markets;

        // Getters and setters


        public List<Coin> getCoins() {
            return coins;
        }

        public void setCoins(List<Coin> coins) {
            this.coins = coins;
        }

        public List<Exchange> getExchanges() {
            return exchanges;
        }

        public void setExchanges(List<Exchange> exchanges) {
            this.exchanges = exchanges;
        }

        public List<Market> getMarkets() {
            return markets;
        }

        public void setMarkets(List<Market> markets) {
            this.markets = markets;
        }

        public static class Coin {
            private String uuid;
            private String iconUrl;
            private String name;
            private String symbol;
            private String price;

            // Getters and setters

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getSymbol() {
                return symbol;
            }

            public void setSymbol(String symbol) {
                this.symbol = symbol;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            @Override
            public String toString() {
                return "Coin{" +
                        "uuid='" + uuid + '\'' +
                        ", iconUrl='" + iconUrl + '\'' +
                        ", name='" + name + '\'' +
                        ", symbol='" + symbol + '\'' +
                        ", price='" + price + '\'' +
                        '}';
            }
        }

        public static class Exchange {
            private String uuid;
            private String baseSymbol;
            private String quoteSymbol;
            private String baseUuid;
            private String quoteUuid;
            private String exchangeIconUrl;
            private String exchangeName;
            private String exchangeUuid;
            private boolean recommended;

            // Getters and setters

            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getBaseSymbol() {
                return baseSymbol;
            }

            public void setBaseSymbol(String baseSymbol) {
                this.baseSymbol = baseSymbol;
            }

            public String getQuoteSymbol() {
                return quoteSymbol;
            }

            public void setQuoteSymbol(String quoteSymbol) {
                this.quoteSymbol = quoteSymbol;
            }

            public String getBaseUuid() {
                return baseUuid;
            }

            public void setBaseUuid(String baseUuid) {
                this.baseUuid = baseUuid;
            }

            public String getQuoteUuid() {
                return quoteUuid;
            }

            public void setQuoteUuid(String quoteUuid) {
                this.quoteUuid = quoteUuid;
            }

            public String getExchangeIconUrl() {
                return exchangeIconUrl;
            }

            public void setExchangeIconUrl(String exchangeIconUrl) {
                this.exchangeIconUrl = exchangeIconUrl;
            }

            public String getExchangeName() {
                return exchangeName;
            }

            public void setExchangeName(String exchangeName) {
                this.exchangeName = exchangeName;
            }

            public String getExchangeUuid() {
                return exchangeUuid;
            }

            public void setExchangeUuid(String exchangeUuid) {
                this.exchangeUuid = exchangeUuid;
            }

            public boolean isRecommended() {
                return recommended;
            }

            public void setRecommended(boolean recommended) {
                this.recommended = recommended;
            }

            @Override
            public String toString() {
                return "Exchange{" +
                        "uuid='" + uuid + '\'' +
                        ", baseSymbol='" + baseSymbol + '\'' +
                        ", quoteSymbol='" + quoteSymbol + '\'' +
                        ", baseUuid='" + baseUuid + '\'' +
                        ", quoteUuid='" + quoteUuid + '\'' +
                        ", exchangeIconUrl='" + exchangeIconUrl + '\'' +
                        ", exchangeName='" + exchangeName + '\'' +
                        ", exchangeUuid='" + exchangeUuid + '\'' +
                        ", recommended=" + recommended +
                        '}';
            }
        }

        public static class Market {
            private String uuid;
            private String baseSymbol;
            private String quoteSymbol;
            private String baseUuid;
            private String quoteUuid;
            private String exchangeIconUrl;
            private String exchangeName;
            private String exchangeUuid;
            private boolean recommended;

            // Getters and setters


            public String getUuid() {
                return uuid;
            }

            public void setUuid(String uuid) {
                this.uuid = uuid;
            }

            public String getBaseSymbol() {
                return baseSymbol;
            }

            public void setBaseSymbol(String baseSymbol) {
                this.baseSymbol = baseSymbol;
            }

            public String getQuoteSymbol() {
                return quoteSymbol;
            }

            public void setQuoteSymbol(String quoteSymbol) {
                this.quoteSymbol = quoteSymbol;
            }

            public String getBaseUuid() {
                return baseUuid;
            }

            public void setBaseUuid(String baseUuid) {
                this.baseUuid = baseUuid;
            }

            public String getQuoteUuid() {
                return quoteUuid;
            }

            public void setQuoteUuid(String quoteUuid) {
                this.quoteUuid = quoteUuid;
            }

            public String getExchangeIconUrl() {
                return exchangeIconUrl;
            }

            public void setExchangeIconUrl(String exchangeIconUrl) {
                this.exchangeIconUrl = exchangeIconUrl;
            }

            public String getExchangeName() {
                return exchangeName;
            }

            public void setExchangeName(String exchangeName) {
                this.exchangeName = exchangeName;
            }

            public String getExchangeUuid() {
                return exchangeUuid;
            }

            public void setExchangeUuid(String exchangeUuid) {
                this.exchangeUuid = exchangeUuid;
            }

            public boolean isRecommended() {
                return recommended;
            }

            public void setRecommended(boolean recommended) {
                this.recommended = recommended;
            }

            @Override
            public String toString() {
                return "Market{" +
                        "uuid='" + uuid + '\'' +
                        ", baseSymbol='" + baseSymbol + '\'' +
                        ", quoteSymbol='" + quoteSymbol + '\'' +
                        ", baseUuid='" + baseUuid + '\'' +
                        ", quoteUuid='" + quoteUuid + '\'' +
                        ", exchangeIconUrl='" + exchangeIconUrl + '\'' +
                        ", exchangeName='" + exchangeName + '\'' +
                        ", exchangeUuid='" + exchangeUuid + '\'' +
                        ", recommended=" + recommended +
                        '}';
            }
        }
    }
}
//    OkHttpClient client = new OkHttpClient();
//
//    Request request = new Request.Builder()
//            .url("https://api.coinranking.com/v2/coins")
//            .get()
//            .addHeader("X-RapidAPI-Key", "coinranking8f4e02ca64e308c673d27c12d8304b5547c3a44bba7756ab")
//            .addHeader("X-RapidAPI-Host", "harrycamps@me.com")
////                .url("https://api.coinranking.com/v2/search-suggestions?query=bitcoin")
////                .url("https://api.coinranking.com/v2/search-suggestions")
//            .build();
//    Response response = client.newCall(request).execute();
//    ResponseBody responseBody = response.body();
//    String responseBodyString = responseBody.string();


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
//                System.out.println(responseBodyString);

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

//                System.out.println("Exchanges:");
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