package com.harrycamps.crypto.Service;

import com.harrycamps.crypto.DAO.CoinDAO;
import com.harrycamps.crypto.DAO.NewsArticleDAO;
import com.harrycamps.crypto.Model.Coin;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataRetriever {
    private final NewsArticleDAO newsArticleDAO;
    private final CoinDAO coinDAO;

    @Autowired
    public DataRetriever(NewsArticleDAO newsArticleDAO, CoinDAO coinDAO) {
        this.newsArticleDAO = newsArticleDAO;
        this.coinDAO = coinDAO;
    }


    @PostConstruct
    public void retrieveData() {
        List<Coin> coins = this.coinDAO.getAllCoins();
        for(Coin c : coins){
            System.out.println(c);
        }

//        // Your code here
//        System.out.println("Running code after Spring context initialization");
//
//        // Retrieve data and print
//        List<NewsArticle> data = newsArticleDAO.getAllArticles();
//        List<Crypto> cryptoData = cryptoDAO.getAllCryptos();
//
//        //List<NewsArticle> articles = newsArticleService.getAllNewsArticles();
//        for (NewsArticle a : data) {
//            System.out.println(a.getNewsId());
//            System.out.println(a.getNewsTitle());
//            System.out.println(a.getNewsSummary());
//            System.out.println(a.getNewsUrl());
//            System.out.println(a.getCryptoName());
//            System.out.println("--------------");
//        }
//        for (Crypto c : cryptoData) {
//            System.out.println(c.getName());
//            System.out.println(c.getCurrentPrice());
//            System.out.println(c.getOldPrice());
//            System.out.println("--------------");
//        }
//
    }
}
