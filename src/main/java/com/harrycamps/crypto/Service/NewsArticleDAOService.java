package com.harrycamps.crypto.Service;

import com.harrycamps.crypto.DAO.NewsArticleDAO;
import com.harrycamps.crypto.DAO.NewsArticleScraper;
import com.harrycamps.crypto.Model.Coin;
import com.harrycamps.crypto.Model.NewsArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsArticleDAOService {
    private final NewsArticleDAO newsArticleDAO;
    private final NewsArticleScraper newsArticleScraper = new NewsArticleScraper();

    @Autowired
    public NewsArticleDAOService(NewsArticleDAO newsArticleDAO) {
        this.newsArticleDAO = newsArticleDAO;
    }

    /**
     * Scrapes news articles for a specific coin and inserts them into the database.
     *
     * @param coinName the name of the coin
     */
    public void insertNewsArticles(String coinName) {
        List<NewsArticle> articles = this.newsArticleScraper.scrapeCoinNews(coinName);
        this.newsArticleDAO.insertNewsArticles(articles);
    }

    /**
     * Scrapes news articles for all coins in the provided list and inserts them into the database.
     *
     * @param coins the list of coins
     */
    public void insertAllNewsArticles(List<Coin> coins) {
        for (Coin coin : coins) {
            this.insertNewsArticles(coin.getName());
        }
    }
}
