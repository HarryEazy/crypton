package com.harrycamps.crypto.DAO;

import com.harrycamps.crypto.DAO.Mappers.CoinMapper;
import com.harrycamps.crypto.DAO.Mappers.NewsArticleMapper;
import com.harrycamps.crypto.Model.Coin;
import com.harrycamps.crypto.Model.NewsArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;


@Repository
public class NewsArticleDAO {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public NewsArticleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<NewsArticle> getAllArticles(){
        String sql = "SELECT * FROM newsarticles;";
        List<NewsArticle> newsArticles = jdbcTemplate.query(sql, new NewsArticleMapper());

        return newsArticles;
    }
    public List<NewsArticle> getAllArticlesForCoin(String coinName) {
        String sql = "SELECT * FROM newsarticles WHERE cryptoname = ?";
        List<NewsArticle> newsArticles = jdbcTemplate.query(sql, new NewsArticleMapper(), coinName);

        return newsArticles;
    }

    public void create(NewsArticle newsArticle) {
        String sql = "INSERT INTO newsarticles (title, url, cryptoname) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, newsArticle.getNewsTitle(), newsArticle.getNewsUrl(), newsArticle.getCryptoName());
    }
    public void insertNewsArticles(List<NewsArticle> newsArticles) {
        String sql = "INSERT INTO newsarticles (title, url, cryptoname) VALUES (?, ?, ?)";
        for (NewsArticle article: newsArticles){
            jdbcTemplate.update(sql, article.getNewsTitle(), article.getNewsUrl(), article.getCryptoName());

        }

    }
    public void deleteAllNewsArticles(){
        String sql = "DELETE FROM newsarticles";
        jdbcTemplate.update(sql);
    }

//    public NewsArticle read(int cid) {
//        String sql = "SELECT * FROM newsarticles WHERE cid = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{cid}, new CoinMapper());
//    }

    public void update(NewsArticle newsArticle) {
        String sql = "UPDATE newsarticles SET title = ?, url = ?, cryptoname = ? WHERE nid = ?";
        jdbcTemplate.update(sql, newsArticle.getNewsTitle(), newsArticle.getCryptoName(), newsArticle.getNewsUrl());
    }

    public void delete(int nid) {
        String sql = "DELETE FROM newsarticles WHERE nid = ?";
        jdbcTemplate.update(sql, nid);
    }



}
