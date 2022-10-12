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
    public int calculateTotalBasedOnSubscriptionType(List<SubscriptionData> inputData, SubscriptionType type) {
        return inputData.stream()
                .filter(s -> s.getSubscriptionType().equals(type))
                .mapToInt(s -> s.getPrice() * s.getNumberOfStocks())
                .sum();
    }


    public int calculateTotalFee(List<SubscriptionData> inputData) {
        return 0;
    }
}
