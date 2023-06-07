# Doc

# Crypto Application Documentation

## Introduction

The Crypto Application is a web application that provides information and news articles about various cryptocurrencies. It allows users to view the latest news related to specific cryptocurrencies and provides real-time price updates for those cryptocurrencies.

## Table of Contents

1. [Features](notion://www.notion.so/Project-ff4d64f8f9bb4ee28b9822c9963bfdd6?p=a5451a5bc3e347b1bd5bab8d41ff7408&showMoveTo=true#features)
2. [Architecture](notion://www.notion.so/Project-ff4d64f8f9bb4ee28b9822c9963bfdd6?p=a5451a5bc3e347b1bd5bab8d41ff7408&showMoveTo=true#architecture)
3. [Components](notion://www.notion.so/Project-ff4d64f8f9bb4ee28b9822c9963bfdd6?p=a5451a5bc3e347b1bd5bab8d41ff7408&showMoveTo=true#components)
4. [Data Access Objects (DAO)](notion://www.notion.so/Project-ff4d64f8f9bb4ee28b9822c9963bfdd6?p=a5451a5bc3e347b1bd5bab8d41ff7408&showMoveTo=true#data-access-objects-dao)
5. [Models](notion://www.notion.so/Project-ff4d64f8f9bb4ee28b9822c9963bfdd6?p=a5451a5bc3e347b1bd5bab8d41ff7408&showMoveTo=true#models)
6. [Services](notion://www.notion.so/Project-ff4d64f8f9bb4ee28b9822c9963bfdd6?p=a5451a5bc3e347b1bd5bab8d41ff7408&showMoveTo=true#services)
7. [Scraping](notion://www.notion.so/Project-ff4d64f8f9bb4ee28b9822c9963bfdd6?p=a5451a5bc3e347b1bd5bab8d41ff7408&showMoveTo=true#scraping)
8. [Initialization](notion://www.notion.so/Project-ff4d64f8f9bb4ee28b9822c9963bfdd6?p=a5451a5bc3e347b1bd5bab8d41ff7408&showMoveTo=true#initialization)

## Features<a name="features"></a>

The Crypto Application offers the following features:

1. View the latest news articles for different cryptocurrencies.
2. Real-time price updates for cryptocurrencies.
3. Search for specific cryptocurrencies.
4. Display detailed information about individual cryptocurrencies.

## Architecture<a name="architecture"></a>

The Crypto Application follows a layered architecture, consisting of the following layers:

1. Presentation Layer: Handles user interaction and displays information to the user.
2. Service Layer: Contains business logic and coordinates the flow of data between the presentation layer and the data access layer.
3. Data Access Layer: Interacts with the database to perform CRUD (Create, Read, Update, Delete) operations.

## Components<a name="components"></a>

The Crypto Application consists of the following components:

1. DAO (Data Access Objects): Responsible for interacting with the database and retrieving or storing data.
2. Models: Represent the data entities used in the application, such as coins and news articles.
3. Services: Implement the business logic and handle the communication between the presentation layer and the data access layer.
4. Scraping: Performs web scraping to retrieve news articles related to specific cryptocurrencies.
5. Initialization: Initializes the application by populating the database with initial data and updating coin prices.

## Data Access Objects (DAO)<a name="data-access-objects-dao"></a>

The DAO classes are responsible for interacting with the database and performing CRUD operations on the data. The following DAO classes are present in the application:

1. CoinDAO: Handles database operations related to coins, such as retrieving all coins, creating a new coin, updating coin information, and deleting a coin.
2. NewsArticleDAO: Handles database operations related to news articles, such as retrieving all articles, creating a new article, updating an article, and deleting an article.

## Models<a name="models"></a>

The models represent the data entities used in the application. The following models are used:

1. Coin: Represents a cryptocurrency with properties such as UUID, symbol, name, icon URL, and price.
2. NewsArticle: Represents a news article related to a cryptocurrency, with properties such as title, URL, and cryptocurrency name.

## Services<a name="services"></a>

The services implement the business logic of the application and handle the communication between the presentation layer and the data access layer. The following services are present:

1. CoinService: Provides methods for retrieving all coins, updating coin prices using an external API, and performing operations on coins.
2. NewsArticleDAOService: Provides methods for scraping news articles for specific cryptocurrencies and inserting them into the database.

## Scraping<a name="scraping"></a>

The application utilizes web scraping to retrieve news articles related to specific cryptocurrencies. The NewsArticleScraper class performs the scraping using the Jsoup library. It fetches the search results page for a given coin name from a news website and extracts the article titles and URLs. The scraped data is then used to create NewsArticle objects and store them in the database.

## Initialization<a name="initialization

"></a>

The ApplicationInitializer class is responsible for initializing the application. It is automatically executed after the application starts, and performs the following tasks:

1. Deletes all existing news articles from the database.
2. Scrapes and inserts news articles for all coins.
3. Updates the prices of all coins using an external API.

These initialization tasks ensure that the application starts with up-to-date news articles and coin prices.

## Conclusion

This documentation provides an overview of the Crypto Application, its features, architecture, components, and initialization process. It serves as a guide for understanding the different parts of the application and how they work together to provide cryptocurrency information to users.

For detailed information on specific classes and methods, please refer to the inline comments and code documentation present in the source code files.
