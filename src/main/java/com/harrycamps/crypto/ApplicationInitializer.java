package com.harrycamps.crypto;

import com.harrycamps.crypto.DAO.CoinApiDOA;
import com.harrycamps.crypto.DAO.CoinDAO;
import com.harrycamps.crypto.DAO.NewsArticleDAO;
import com.harrycamps.crypto.Model.Coin;
import com.harrycamps.crypto.Service.CoinService;
import com.harrycamps.crypto.Service.NewsArticleDAOService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class ApplicationInitializer {

    private final NewsArticleDAO newsArticleDAO;
    private final CoinDAO coinDAO;
    private final NewsArticleDAOService newsArticleDAOService;

    @Autowired
    public ApplicationInitializer(NewsArticleDAO newsArticleDAO, CoinDAO coinDAO, NewsArticleDAOService newsArticleDAOService) {
        this.newsArticleDAO = newsArticleDAO;
        this.coinDAO = coinDAO;
        this.newsArticleDAOService = newsArticleDAOService;
    }

    @PostConstruct
    public void initialize() throws IOException, InterruptedException {
        // Call the methods to be executed once on site load

        // Delete all existing news articles
        newsArticleDAO.deleteAllNewsArticles();

        // Insert news articles for all coins
        newsArticleDAOService.insertAllNewsArticles(coinDAO.getAllCoins());

        // Initialize CoinApiDOA and CoinService
        CoinApiDOA coinApiDOA = new CoinApiDOA();
        CoinService coinService = new CoinService(this.coinDAO, coinApiDOA);

        // Update the prices of all coins
        coinService.updateAllPrices();
    }
}
