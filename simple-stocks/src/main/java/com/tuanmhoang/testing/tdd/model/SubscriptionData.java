package com.tuanmhoang.testing.tdd.model;

import com.tuanmhoang.testing.tdd.subscription.SubscriptionType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionData {
    private int price;
    private int numberOfStocks;
    private SubscriptionType subscriptionType;
}
