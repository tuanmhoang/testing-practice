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

givenListOfSubscriptions_whenCalculate_thenCalculateTotalSell()

givenListOfSubscriptions_whenCalculate_thenCalculateTotalFee()

givenListOfSubscriptions_whenCalculate_thenCalculateTotalTax()

givenListOfSubscriptions_whenCalculate_thenCalculateTotalFeeAndTax()
```

Then we can populate the result to report and display
