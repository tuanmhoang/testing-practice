package com.tuanmhoang.testing.tdd.service;

import com.tuanmhoang.testing.tdd.model.SubscriptionData;
import com.tuanmhoang.testing.tdd.subscription.SubscriptionType;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

public class StockService {

    public int calculateTotalPrice(int price, int numberOfStocks) {
        return price * numberOfStocks;
    }

    public int calculateTotalBuy(List<SubscriptionData> inputData) {
        return inputData.stream()
                .filter(s -> s.getSubscriptionType().equals(SubscriptionType.BUY))
                .mapToInt(s -> s.getPrice() * s.getNumberOfStocks())
                .sum();
    }

    public int calculateTotalSell(List<SubscriptionData> inputData) {
        return inputData.stream()
                .filter(s -> s.getSubscriptionType().equals(SubscriptionType.SELL))
                .mapToInt(s -> s.getPrice() * s.getNumberOfStocks())
                .sum();
    }


}
