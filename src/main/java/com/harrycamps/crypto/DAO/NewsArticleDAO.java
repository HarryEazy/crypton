package com.harrycamps.crypto.DAO;

import com.harrycamps.crypto.DAO.Mappers.NewsArticleMapper;
import com.harrycamps.crypto.Model.NewsArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsArticleDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public NewsArticleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Retrieves all news articles from the "newsarticles" table.
     *
     * @return List of news articles
     */
    public List<NewsArticle> getAllArticles() {
        String sql = "SELECT * FROM newsarticles;";
        return jdbcTemplate.query(sql, new NewsArticleMapper());
    }

    /**
     * Retrieves all news articles related to a specific coin from the "newsarticles" table.
     *
     * @param coinName Name of the coin
     * @return List of news articles for the coin
     */
    public List<NewsArticle> getAllArticlesForCoin(String coinName) {
        String sql = "SELECT * FROM newsarticles WHERE cryptoname = ?";
        return jdbcTemplate.query(sql, new NewsArticleMapper(), coinName);
    }

    /**
     * Creates a new news article in the "newsarticles" table.
     *
     * @param newsArticle NewsArticle object to be created
     */
    public void create(NewsArticle newsArticle) {
        String sql = "INSERT INTO newsarticles (title, url, cryptoname) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, newsArticle.getNewsTitle(), newsArticle.getNewsUrl(), newsArticle.getCryptoName());
    }

    /**
     * Inserts a list of news articles into the "newsarticles" table.
     *
     * @param newsArticles List of news articles to be inserted
     */
    public void insertNewsArticles(List<NewsArticle> newsArticles) {
        String sql = "INSERT INTO newsarticles (title, url, cryptoname) VALUES (?, ?, ?)";
        for (NewsArticle article : newsArticles) {
            jdbcTemplate.update(sql, article.getNewsTitle(), article.getNewsUrl(), article.getCryptoName());
        }
    }

    /**
     * Deletes all news articles from the "newsarticles" table.
     */
    public void deleteAllNewsArticles() {
        String sql = "DELETE FROM newsarticles";
        jdbcTemplate.update(sql);
    }

    /**
     * Updates the details of a specific news article in the "newsarticles" table.
     *
     * @param newsArticle NewsArticle object to be updated
     */
    public void update(NewsArticle newsArticle) {
        String sql = "UPDATE newsarticles SET title = ?, url = ?, cryptoname = ? WHERE nid = ?";
        jdbcTemplate.update(sql, newsArticle.getNewsTitle(), newsArticle.getNewsUrl(), newsArticle.getCryptoName(), newsArticle.getNewsId());
    }

    /**
     * Deletes a specific news article from the "newsarticles" table based on its nid.
     *
     * @param nid News article ID
     */
    public void delete(int nid) {
        String sql = "DELETE FROM newsarticles WHERE nid = ?";
        jdbcTemplate.update(sql, nid);
    }
}
