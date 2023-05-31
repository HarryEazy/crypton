package com.harrycamps.crypto.Model;

public class NewsArticle {
    private int newsId;
    private String newsTitle;
    private String newsUrl;
    private String cryptoName;

    public NewsArticle( String newsTitle,  String newsUrl, String cryptoName) {
        this.newsTitle = newsTitle;
        this.newsUrl = newsUrl;
        this.cryptoName = cryptoName;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsUrl() {
        return this.newsUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

    public String getCryptoName() {
        return cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }
}
