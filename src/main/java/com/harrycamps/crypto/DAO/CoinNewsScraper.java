package com.harrycamps.crypto.DAO;

import com.harrycamps.crypto.Model.NewsArticle;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CoinNewsScraper {
    private static final String SEARCH_URL = "https://www.newsnow.co.uk/h/Business+&+Finance/Cryptocurrencies/";


    public void scrapeCoinNews(String coinName) {
        try {
            // Construct the search URL with the coin name
            String searchUrl = SEARCH_URL + coinName;

            // Fetch the search results page
            Document document = Jsoup.connect(searchUrl).get();
            System.out.println("SEARCHING...");
            Elements articleElements = document.select("div.hl");

            List<NewsArticle> newsArticles = new ArrayList<>();
            int count = 0;
            for (Element articleElement : articleElements) {
                if (count >= 10) {
                    break; // Stop the loop after retrieving the first 5 articles
                }
//                Element linkElement = articleElement.selectFirst("a.hll");
//                String url = linkElement.attr("href");
//                String title = linkElement.text();
//
//                Element summaryElement = articleElement.selectFirst("div.hl__inner");
//                String summary = summaryElement.ownText();
//
//                NewsArticle newsArticle = new NewsArticle(url, title, summary, coinName);
//                newsArticles.add(newsArticle);

                Element linkElement = articleElement.selectFirst("a.hll");
                String url = linkElement.attr("href");
                String title = linkElement.text();

                Element summaryElement = articleElement.selectFirst("div.hl__inner");
                String summary = summaryElement.ownText();
//                public NewsArticle( String newsTitle, String newsSummary, String newsUrl, String cryptoName) {
                NewsArticle newsArticle = new NewsArticle(title, url, coinName);
                newsArticles.add(newsArticle);

                count++;
            }

            // Print the news articles
            for (NewsArticle article : newsArticles) {
                System.out.println("NAME: " + article.getCryptoName());
                System.out.println("URL: " + article.getNewsUrl());
                System.out.println("Title: " + article.getNewsTitle());
                System.out.println();
            }





        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
