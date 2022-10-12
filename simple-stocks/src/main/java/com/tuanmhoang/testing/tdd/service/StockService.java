package com.tuanmhoang.testing.tdd.service;

import com.tuanmhoang.testing.tdd.model.SubscriptionData;

import java.math.BigInteger;
import java.util.List;

public class StockService {

    public int calculateTotalPrice(int price, int numberOfStocks) {
        return price * numberOfStocks;
    }

    public int calculateTotalBuy(List<SubscriptionData> inputData){
        return 0;
    }
}
