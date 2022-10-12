package com.tuanmhoang.testing.tdd.service;

import com.tuanmhoang.testing.tdd.model.SubscriptionData;
import com.tuanmhoang.testing.tdd.subscription.SubscriptionType;

import java.util.List;

public class StockService {

    private static final double BROKER_FEE = 0.0015;

    private static final double TAX_FEE = 0.001;

    public int calculateTotalPrice(int price, int numberOfStocks) {
        return price * numberOfStocks;
    }

    public int calculateTotalBasedOnSubscriptionType(List<SubscriptionData> inputData, SubscriptionType type) {
        return inputData.stream()
                .filter(s -> s.getSubscriptionType().equals(type))
                .mapToInt(s -> s.getPrice() * s.getNumberOfStocks())
                .sum();
    }


    public int calculateTotalBrokerFee(List<SubscriptionData> inputData) {
        return inputData.stream()
                .mapToInt(s -> (int) (s.getPrice() * s.getNumberOfStocks() * BROKER_FEE))
                .sum();
    }

    public int calculateTotalTax(List<SubscriptionData> inputData) {
        return (int) (calculateTotalBasedOnSubscriptionType(inputData, SubscriptionType.SELL) * TAX_FEE);
    }

    public int calculateTotalBrokerFeeAndTax(List<SubscriptionData> inputData) {
        return calculateTotalBrokerFee(inputData) + calculateTotalTax(inputData);
    }
}
