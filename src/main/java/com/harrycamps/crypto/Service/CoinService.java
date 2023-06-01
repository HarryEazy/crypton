package com.harrycamps.crypto.Service;

import com.harrycamps.crypto.DAO.CoinApiDOA;
import com.harrycamps.crypto.DAO.CoinDAO;
import com.harrycamps.crypto.Model.Coin;

import java.io.IOException;
import java.util.List;

public class CoinService {
    private final CoinDAO coinDAO;
    private final CoinApiDOA coinApiDOA;

    public CoinService(CoinDAO coinDAO, CoinApiDOA coinApiDOA) {
        this.coinDAO = coinDAO;
        this.coinApiDOA = coinApiDOA;
    }

    /**
     * Retrieves all coins from the database.
     *
     * @return List of all coins
     */
    public List<Coin> getAllCoins() {
        return coinDAO.getAllCoins();
    }

    /**
     * Updates the prices of all coins by calling the Coin API.
     *
     * @throws IOException            if there is an error in making the API request
     * @throws InterruptedException if the thread is interrupted during the delay
     */
    public void updateAllPrices() throws IOException, InterruptedException {
        List<Coin> coins = getAllCoins();

        for (Coin coin : coins) {
            String uuid = coin.getUuid();
            double price = coinApiDOA.getPrice(uuid);

            // Skip coins with invalid or zero price
            if (price <= 0) {
                continue;
            }

            coin.setPrice(price);

            coinDAO.update(coin);
        }
    }
}
