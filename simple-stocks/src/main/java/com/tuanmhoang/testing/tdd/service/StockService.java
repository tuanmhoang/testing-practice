package com.tuanmhoang.testing.tdd.service;

import java.math.BigInteger;

public class StockService {

    public int calculateTotalPrice(int price, int numberOfStocks) {
        return price * numberOfStocks;
    }
}
