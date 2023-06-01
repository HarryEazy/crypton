package com.harrycamps.crypto.Controllers;

import com.harrycamps.crypto.DAO.CoinApiDOA;
import com.harrycamps.crypto.DAO.CoinDAO;
import com.harrycamps.crypto.DAO.NewsArticleDAO;
import com.harrycamps.crypto.Service.CoinService;
import com.harrycamps.crypto.Service.NewsArticleDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

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

    /**
     * Executes an hourly task to update news articles and coin prices.
     *
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the thread is interrupted -> NO LONGER USES THREAD.SLEEP
     */
    @Scheduled(cron = "0 0 * * * *") // Runs every hour at the 0th minute
    public void executeHourlyTask() throws IOException, InterruptedException {
        newsArticleDAO.deleteAllNewsArticles();
        newsArticleDAOService.insertAllNewsArticles(coinDAO.getAllCoins());
        CoinApiDOA coinApiDOA = new CoinApiDOA();
        CoinService coinService = new CoinService(this.coinDAO, coinApiDOA);
        coinService.updateAllPrices();
    }
}
