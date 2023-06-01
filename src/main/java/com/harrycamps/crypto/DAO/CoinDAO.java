package com.harrycamps.crypto.DAO;

import com.harrycamps.crypto.DAO.Mappers.CoinMapper;
import com.harrycamps.crypto.Model.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoinDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CoinDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Retrieves all coins from the "coins" table.
     *
     * @return List of coins
     */
    public List<Coin> getAllCoins() {
        String sql = "SELECT * FROM coins;";
        return jdbcTemplate.query(sql, new CoinMapper());
    }

    /**
     * Retrieves a specific coin from the "coins" table based on its cid.
     *
     * @param cid Coin ID
     * @return Coin object
     */
    public Coin read(int cid) {
        String sql = "SELECT * FROM coins WHERE cid = ?";
        return jdbcTemplate.queryForObject(sql, new CoinMapper(), cid);
    }

    /**
     * Inserts a new coin into the "coins" table.
     *
     * @param coin Coin object to be created
     */
    public void create(Coin coin) {
        String sql = "INSERT INTO coins (uuid, symbol, name, iconUrl, price) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, coin.getUuid(), coin.getSymbol(), coin.getName(), coin.getIconUrl(), coin.getPrice());
    }

    /**
     * Inserts a list of coins into the "coins" table.
     *
     * @param coins List of coins to be inserted
     */
    public void insertTop8Coins(List<Coin> coins) {
        String sql = "INSERT INTO coins (uuid, symbol, name, iconUrl, price) VALUES (?, ?, ?, ?, ?)";
        for (Coin coin : coins) {
            jdbcTemplate.update(sql, coin.getUuid(), coin.getSymbol(), coin.getName(), coin.getIconUrl(), coin.getPrice());
        }
    }

    /**
     * Updates the details of a specific coin in the "coins" table.
     *
     * @param coin Coin object to be updated
     */
    public void update(Coin coin) {
        String sql = "UPDATE coins SET uuid = ?, symbol = ?, name = ?, iconUrl = ?, price = ? WHERE cid = ?";
        jdbcTemplate.update(sql, coin.getUuid(), coin.getSymbol(), coin.getName(), coin.getIconUrl(), coin.getPrice(), coin.getCid());
    }

    /**
     * Retrieves a specific coin from the "coins" table based on its name.
     *
     * @param name Coin name
     * @return Coin object
     */
    public Coin getCoinByName(String name) {
        String sql = "SELECT * FROM coins WHERE name = ?";
        return jdbcTemplate.queryForObject(sql, new CoinMapper(), name);
    }

    /**
     * Deletes a specific coin from the "coins" table based on its cid.
     *
     * @param cid Coin ID
     */
    public void delete(int cid) {
        String sql = "DELETE FROM coins WHERE cid = ?";
        jdbcTemplate.update(sql, cid);
    }
}
