package com.harrycamps.crypto.Model;

import java.util.List;

public class ApiResponseTop8Coins {
    private String status;
    private Data data;

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
    }

    public static class Coin {
        private String uuid;
        private String iconUrl;
        private String name;
        private String symbol;
        private String price;

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
        private String iconUrl;
        private String name;
        private boolean recommended;

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
                    ", iconUrl='" + iconUrl + '\'' +
                    ", name='" + name + '\'' +
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

