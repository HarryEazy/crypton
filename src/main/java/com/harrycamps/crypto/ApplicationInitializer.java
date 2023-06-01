package com.harrycamps.crypto;
import com.harrycamps.crypto.DAO.CoinDAO;
import com.harrycamps.crypto.DAO.NewsArticleDAO;
import com.harrycamps.crypto.Service.NewsArticleDAOService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public void initialize() {
        // Call the methods to be executed once on site load
        newsArticleDAO.deleteAllNewsArticles();
        newsArticleDAOService.insertAllNewsArticles(coinDAO.getAllCoins());
    }
}
