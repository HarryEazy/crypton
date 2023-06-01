package com.harrycamps.crypto.Controllers;

import com.harrycamps.crypto.DAO.CoinDAO;
import com.harrycamps.crypto.DAO.NewsArticleDAO;
import com.harrycamps.crypto.Service.NewsArticleDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class HourlyTask {

    private final NewsArticleDAO newsArticleDAO;
    private final CoinDAO coinDAO;
    private final NewsArticleDAOService newsArticleDAOService;

    @Autowired
    public HourlyTask(NewsArticleDAO newsArticleDAO, CoinDAO coinDAO, NewsArticleDAOService newsArticleDAOService) {
        this.newsArticleDAO = newsArticleDAO;
        this.coinDAO = coinDAO;
        this.newsArticleDAOService = newsArticleDAOService;
    }

    @Scheduled(cron = "0 0 * * * *") // Runs every hour at the 0th minute
    public void executeHourlyTask() {
        newsArticleDAO.deleteAllNewsArticles();
        newsArticleDAOService.insertAllNewsArticles(coinDAO.getAllCoins());
    }
}

