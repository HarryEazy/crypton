package com.harrycamps.crypto;

import com.harrycamps.crypto.DAO.NewsArticleDAO;
import com.harrycamps.crypto.Model.NewsArticle;
import com.harrycamps.crypto.Service.NewsArticleService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootApplication
public class CryptoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoApplication.class, args);
//		JdbcTemplate jdbcTemplate = new JdbcTemplate();
//		NewsArticleDAO newsArticleDAO = new NewsArticleDAO(jdbcTemplate);
		System.out.println("Running code from the main method");


		System.out.println("Running code from AFTER the main method");
//		NewsArticleService newsArticleService = new NewsArticleService(newsArticleDAO);
//		List<NewsArticle> articles = newsArticleService.getAllNewsArticles();
//		for (NewsArticle a : articles) {
//			System.out.println(a.getNewsId());
//			System.out.println(a.getNewsTitle());
//			System.out.println(a.getNewsSummary());
//			System.out.println(a.getNewsUrl());
//			System.out.println("--------------");
//		}


	}

}
