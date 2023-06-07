package com.harrycamps;
import com.harrycamps.crypto.CryptoApplication;
import com.harrycamps.crypto.DAO.CoinDAO;
import com.harrycamps.crypto.Model.Coin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

//@DataJdbcTest
@SpringBootTest(classes = CryptoApplication.class)
public class CoinTest {

    private CoinDAO coinDAO;
    private JdbcTemplate jdbcTemplate;
    private Coin testCoin = new Coin();


    @Autowired
    public CoinTest(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        coinDAO = new CoinDAO(jdbcTemplate);
        testCoin.setPrice(7);
        testCoin.setName("TestCoin");
        testCoin.setSymbol("TC");
        testCoin.setIconUrl("example.com");
        testCoin.setUuid("testUUID");
    }

    @Test
    @DisplayName("Test to add new coin")
    public void addNewCoinTest(){
        int previousSize = this.coinDAO.getAllCoins().size();
        this.coinDAO.create(testCoin);
        this.testCoin.setCid(this.coinDAO.getCoinByName(testCoin.getName()).getCid());
        System.out.println(testCoin);
        int newSize = this.coinDAO.getAllCoins().size();
        assertEquals(previousSize + 1, newSize);
    }
    @Test
    @DisplayName("Test update coin")
    public void updateCoinTest(){
        this.coinDAO.create(testCoin);
        this.testCoin.setCid(this.coinDAO.getCoinByName(testCoin.getName()).getCid());
        testCoin.setName("updatedTestCoin");
        System.out.println(testCoin);
        this.coinDAO.update(testCoin);
        Coin newCoin = this.coinDAO.getCoinByName("updatedTestCoin");
        assertEquals(testCoin.getName(), newCoin.getName());
    }

    @Test
    @DisplayName("Test delete coin")
    public void deleteCoinTest(){
        this.coinDAO.deleteAllByName(testCoin.getName());
        this.coinDAO.create(testCoin);
        this.testCoin.setCid(this.coinDAO.getCoinByName(testCoin.getName()).getCid());
        int previousSize = this.coinDAO.getAllCoins().size();
        this.coinDAO.delete(testCoin.getCid());

        int newSize = this.coinDAO.getAllCoins().size();
        assertEquals(previousSize - 1, newSize);
    }


}
