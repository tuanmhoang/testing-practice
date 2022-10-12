# TDD - simple stocks

## Requirements

### US01
As an app, it should display the stock price, the number that user can buy/sell and the total price.

Example:

![Screen Shot 2022-10-12 at 21 31 44](https://user-images.githubusercontent.com/37680968/195371061-f8d0424a-d474-443c-a8eb-1a79474da8b7.png)

Test case: 

```
givenStockPriceNumberOfStock_whenUserViewData_thenCalculateTotalPrice()
```

### US02
As a user, I should be able to see the report after a day of subscriptions.

![Screen Shot 2022-10-12 at 22 04 20](https://user-images.githubusercontent.com/37680968/195379004-a61997a7-0692-4243-b714-3ac403daad4b.png)

Here, let's break into small parts
- calculate for total price
- calculate for total sell
- calculate for total fee
- calculate for total tax
- calculate for total fee and tax

```
givenListOfSubscriptions_whenCalculate_thenCalculateTotalBuy()

// assertEquals(17780000, stockService.calculateTotalBuy(inputData));

    public int calculateTotalBuy(List<SubscriptionData> inputData) {
        return inputData.stream()
                .filter(s -> s.getSubscriptionType().equals(SubscriptionType.BUY))
                .mapToInt(s -> s.getPrice() * s.getNumberOfStocks())
                .sum();
    }
/***************************/
givenListOfSubscriptions_whenCalculate_thenCalculateTotalSell()

// assertEquals(24850000, stockService.calculateTotalSell(inputData));

    public int calculateTotalSell(List<SubscriptionData> inputData) {
        return inputData.stream()
                .filter(s -> s.getSubscriptionType().equals(SubscriptionType.SELL))
                .mapToInt(s -> s.getPrice() * s.getNumberOfStocks())
                .sum();
    }

// BLUE
    public int calculateTotalBasedOnSubscriptionType(List<SubscriptionData> inputData, SubscriptionType type) {
        return inputData.stream()
                .filter(s -> s.getSubscriptionType().equals(type))
                .mapToInt(s -> s.getPrice() * s.getNumberOfStocks())
                .sum();
    }          
                
/***************************/
givenListOfSubscriptions_whenCalculate_thenCalculateTotalBrokerFee()

// assertEquals(63945, stockService.calculateTotalBrokerFee(inputData));

    public int calculateTotalBrokerFee(List<SubscriptionData> inputData) {
        return inputData.stream()
                .mapToInt(s -> (int) (s.getPrice() * s.getNumberOfStocks() * BROKER_FEE))
                .sum();
    }

/***************************/
givenListOfSubscriptions_whenCalculate_thenCalculateTotalTax()

//  assertEquals(24850,stockService.calculateTotalTax(inputData));

    public int calculateTotalTax(List<SubscriptionData> inputData) {
        return (int) (calculateTotalBasedOnSubscriptionType(inputData,SubscriptionType.SELL)*TAX_FEE);
    }

/***************************/
givenListOfSubscriptions_whenCalculate_thenCalculateTotalFeeAndTax()

// assertEquals(88795, stockService.calculateTotalBrokerFeeAndTax(inputData));

    public int calculateTotalBrokerFeeAndTax(List<SubscriptionData> inputData) {
        return calculateTotalBrokerFee(inputData) + calculateTotalTax(inputData);
    }
```

Testing data for US02

```
        List<SubscriptionData> inputData = Arrays.asList(
                SubscriptionData.builder().price(12700).numberOfStocks(1400).subscriptionType(SubscriptionType.BUY).build(),
                SubscriptionData.builder().price(11350).numberOfStocks(1000).subscriptionType(SubscriptionType.SELL).build(),
                SubscriptionData.builder().price(13500).numberOfStocks(1000).subscriptionType(SubscriptionType.BUY).build()

        );
```

Then we can populate the result to report and display
