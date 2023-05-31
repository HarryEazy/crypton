package com.harrycamps.crypto.DAO.Mappers;
import com.harrycamps.crypto.Model.NewsArticle;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsArticleMapper implements RowMapper<NewsArticle> {


    @Override
    public NewsArticle mapRow(ResultSet rs, int rowNum) throws SQLException {
        NewsArticle newsArticle; // Instantiate a Course object
        int newsArticleID = rs.getInt(1);
        String newsArticleTitle = rs.getString(2);
        String newsArticleURL = rs.getString(3);
        String cryptoName = rs.getString(4);
        newsArticle = new NewsArticle( newsArticleTitle, newsArticleURL, cryptoName);
        newsArticle.setNewsId(newsArticleID);

        return  newsArticle;

    }
}
