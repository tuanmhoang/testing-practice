package com.tuanmhoang.testing.tdd.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockServiceTest {

    private StockService stockService = new StockService();

    @Test
    public void givenStockPriceNumberOfStock_whenUserViewData_thenCalculateTotalPrice(){
        assertEquals(1000000,stockService.calculateTotalPrice(10000, 100));
        assertEquals(9000000,stockService.calculateTotalPrice(45000, 200));
    }
}
