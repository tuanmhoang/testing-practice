package com.tuanmhoang.testing.tdd.service;

import com.tuanmhoang.testing.tdd.model.SubscriptionData;
import com.tuanmhoang.testing.tdd.subscription.SubscriptionType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockServiceTest {

    private StockService stockService = new StockService();

    @Test
    public void givenStockPriceNumberOfStock_whenUserViewData_thenCalculateTotalPrice(){
        assertEquals(1000000,stockService.calculateTotalPrice(10000, 100));
        assertEquals(9000000,stockService.calculateTotalPrice(45000, 200));
    }

    @Test
    public void givenListOfSubscriptions_whenCalculate_thenCalculateTotalBuy(){
        List<SubscriptionData> inputData = Arrays.asList(
                SubscriptionData.builder().price(12700).numberOfStocks(1400).subscriptionType(SubscriptionType.BUY).build(),
                SubscriptionData.builder().price(11350).numberOfStocks(1000).subscriptionType(SubscriptionType.SELL).build(),
                SubscriptionData.builder().price(13500).numberOfStocks(1000).subscriptionType(SubscriptionType.SELL).build()
        );
        // 12700*1400
        assertEquals(17780000, stockService.calculateTotalBasedOnSubscriptionType(inputData,SubscriptionType.BUY));
    }

    @Test
    public  void givenListOfSubscriptions_whenCalculate_thenCalculateTotalSell(){
        List<SubscriptionData> inputData = Arrays.asList(
                SubscriptionData.builder().price(12700).numberOfStocks(1400).subscriptionType(SubscriptionType.BUY).build(),
                SubscriptionData.builder().price(11350).numberOfStocks(1000).subscriptionType(SubscriptionType.SELL).build(),
                SubscriptionData.builder().price(13500).numberOfStocks(1000).subscriptionType(SubscriptionType.SELL).build()
        );
        // 11350*1000+13500*1000
        assertEquals(24850000, stockService.calculateTotalBasedOnSubscriptionType(inputData,SubscriptionType.SELL));
    }
}
