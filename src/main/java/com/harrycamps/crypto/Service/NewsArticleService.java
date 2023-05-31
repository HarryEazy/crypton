package com.harrycamps.crypto.Service;

import com.harrycamps.crypto.DAO.NewsArticleDAO;
import com.harrycamps.crypto.Model.NewsArticle;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class NewsArticleService {
    private final NewsArticleDAO newsArticleDAO;

    @Autowired
    public NewsArticleService(NewsArticleDAO newsArticleDAO) {
        this.newsArticleDAO = newsArticleDAO;
    }

    public List<NewsArticle> getAllNewsArticles() {
        return newsArticleDAO.getAllArticles();
    }

}
