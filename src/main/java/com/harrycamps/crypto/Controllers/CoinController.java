package com.harrycamps.crypto.Controllers;

import com.harrycamps.crypto.DAO.CoinDAO;
import com.harrycamps.crypto.DAO.NewsArticleScraper;
import com.harrycamps.crypto.DAO.NewsArticleDAO;
import com.harrycamps.crypto.Model.Coin;
import com.harrycamps.crypto.Model.NewsArticle;
import com.harrycamps.crypto.Service.NewsArticleDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/coins")
public class CoinController {
    private final CoinDAO coinDAO;
    private final NewsArticleDAO newsArticleDAO;
    private final NewsArticleDAOService newsArticleDAOService;

    @Autowired
    public CoinController(CoinDAO coinDAO, NewsArticleDAO newsArticleDAO, NewsArticleDAOService newsArticleDAOService) {
        this.coinDAO = coinDAO;
        this.newsArticleDAO = newsArticleDAO;
        this.newsArticleDAOService = newsArticleDAOService;
    }

    @GetMapping("/details/test")
    public String getTest(Model model) {
        model.addAttribute("name", "WZZZP");
        return "test";
    }

    @GetMapping("/details")
    public String getCoinDetails(Model model) {
        // Retrieve the list of coins from the CoinDAO
        List<Coin> coins = coinDAO.getAllCoins();

        model.addAttribute("coins", coins);

        return "coin-details";
    }

    @GetMapping("details/{coinName}")
    public String getCoinInfo(@PathVariable("coinName") String coinName, Model model) {

        List<NewsArticle> newsArticles = newsArticleDAO.getAllArticlesForCoin(coinName);



        System.out.println("FINDING COIN");
        Coin coin = coinDAO.getCoinByName(coinName);

        model.addAttribute("coin", coin);
        model.addAttribute("newsArticles", newsArticles);
        return "coin-news";
    }
}



