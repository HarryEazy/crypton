package com.harrycamps.crypto.DAO.Mappers;
import com.harrycamps.crypto.Model.Coin;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

//private int cid;
//private String uuid;
//private String symbol;
//private String name;
//private String iconUrl;
//private String price;

public class CoinMapper implements RowMapper<Coin> {
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
