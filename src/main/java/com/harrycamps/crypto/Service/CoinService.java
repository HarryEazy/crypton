package com.harrycamps.crypto.Service;
import com.harrycamps.crypto.DAO.CoinApiDOA;
import com.harrycamps.crypto.DAO.CoinDAO;
import com.harrycamps.crypto.Model.Coin;

import java.io.IOException;
import java.util.List;

public class CoinService {
    private final CoinDAO coinDAO;
    private final CoinApiDOA coinApiController;

    public CoinService(CoinDAO coinDAO, CoinApiDOA coinApiController) {
        this.coinDAO = coinDAO;
        this.coinApiController = coinApiController;
    }

    public List<Coin> getAllCoins() {
        return coinDAO.getAllCoins();
    }

    public void updateAllPrices() throws IOException {
        List<Coin> coins = getAllCoins();

        for (Coin coin : coins) {
            String uuid = coin.getUuid();
            String priceString = coinApiController.getPrice(uuid);
            double price = Double.parseDouble(priceString);
            coin.setPrice(price);

            coinDAO.update(coin);
        }
    }
}

