package com.harrycamps.crypto.DAO.Mappers;

import com.harrycamps.crypto.Model.NewsArticle;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsArticleMapper implements RowMapper<NewsArticle> {

    /**
     * Maps a row of the ResultSet to a NewsArticle object.
     *
     * @param rs     the ResultSet
     * @param rowNum the current row number
     * @return the mapped NewsArticle object
     * @throws SQLException if a database access error occurs
     */
    @Override
    public NewsArticle mapRow(ResultSet rs, int rowNum) throws SQLException {
        NewsArticle newsArticle; // Instantiate a NewsArticle object
        int newsArticleID = rs.getInt(1);
        String newsArticleTitle = rs.getString(2);
        String newsArticleURL = rs.getString(3);
        String cryptoName = rs.getString(4);
        newsArticle = new NewsArticle(newsArticleTitle, newsArticleURL, cryptoName);
        newsArticle.setNewsId(newsArticleID);

        return newsArticle;
    }
}
