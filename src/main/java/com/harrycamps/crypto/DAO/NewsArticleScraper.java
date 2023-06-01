package com.harrycamps.crypto.DAO;

import com.harrycamps.crypto.Model.NewsArticle;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewsArticleScraper {

    private static final String SEARCH_URL = "https://www.newsnow.co.uk/h/Business+&+Finance/Cryptocurrencies/";

    /**
     * Scrapes news articles related to a specific coin.
     *
     * @param coinName Name of the coin
     * @return List of scraped news articles
     */
    public List<NewsArticle> scrapeCoinNews(String coinName) {
        List<NewsArticle> newsArticles = new ArrayList<>();
        try {
            // Construct the search URL with the coin name
            String searchUrl = SEARCH_URL + coinName;

            // Fetch the search results page
            Document document = Jsoup.connect(searchUrl).get();
            Elements articleElements = document.select("div.hl");

            int count = 0;
            for (Element articleElement : articleElements) {
                if (count >= 10) {
                    break; // Stop the loop after retrieving the first 10 articles
                }

                Element linkElement = articleElement.selectFirst("a.hll");
                String url = linkElement.attr("href");
                String title = linkElement.text();

                NewsArticle newsArticle = new NewsArticle(title, url, coinName);
                newsArticles.add(newsArticle);
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return newsArticles;
    }
}
