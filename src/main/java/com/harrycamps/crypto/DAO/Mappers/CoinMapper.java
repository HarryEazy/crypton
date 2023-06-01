package com.harrycamps.crypto.DAO.Mappers;

import com.harrycamps.crypto.Model.Coin;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoinMapper implements RowMapper<Coin> {

    /**
     * Maps a row of the ResultSet to a Coin object.
     *
     * @param rs     the ResultSet
     * @param rowNum the current row number
     * @return the mapped Coin object
     * @throws SQLException if a database access error occurs
     */
    @Override
    public Coin mapRow(ResultSet rs, int rowNum) throws SQLException {
        Coin coin = new Coin();
        int cid = rs.getInt(1);
        String uuid = rs.getString(2);
        String symbol = rs.getString(3);
        String name = rs.getString(4);
        String iconUrl = rs.getString(5);
        double price = rs.getDouble(6);

        coin.setCid(cid);
        coin.setUuid(uuid);
        coin.setSymbol(symbol);
        coin.setName(name);
        coin.setIconUrl(iconUrl);
        coin.setPrice(price);

        return coin;
    }
}
