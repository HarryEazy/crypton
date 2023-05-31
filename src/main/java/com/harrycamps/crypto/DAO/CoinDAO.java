package com.harrycamps.crypto.DAO;
import com.harrycamps.crypto.DAO.Mappers.CoinMapper;
import com.harrycamps.crypto.Model.Coin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoinDAO {
    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public CoinDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Coin> getAllCoins(){
        String sql = "SELECT * FROM coins;";
        List<Coin> coins = jdbcTemplate.query(sql, new CoinMapper());
        return coins;
    }
    public void create(Coin coin) {
        String sql = "INSERT INTO coins (uuid, symbol, name, iconUrl, marketcap, price) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, coin.getUuid(), coin.getSymbol(), coin.getName(), coin.getIconUrl(), coin.getPrice());
    }

    public Coin read(int cid) {
        String sql = "SELECT * FROM coins WHERE cid = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{cid}, new CoinMapper());
    }

    public void update(Coin coin) {
        String sql = "UPDATE coins SET uuid = ?, symbol = ?, name = ?, iconUrl = ?, price = ? WHERE cid = ?";
        jdbcTemplate.update(sql, coin.getUuid(), coin.getSymbol(), coin.getName(), coin.getIconUrl(), coin.getPrice(), coin.getCid());
    }

    public void delete(int cid) {
        String sql = "DELETE FROM coins WHERE cid = ?";
        jdbcTemplate.update(sql, cid);
    }

}
