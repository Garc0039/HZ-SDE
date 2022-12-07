package com.hz;

public class Checkout {

    private DiscountStrategy discountStrategy;

    public Checkout() {

    }

    public void setStrategyChristmas() {
        discountStrategy = new ChristmasDiscountStrategy();
    }

    public void setStrategyBlackFriday() {
        discountStrategy = new BlackFridayDiscountStrategy();
    }

    public void setNoAction() {
        discountStrategy = new NoActionStrategy();
    }

    public void nextInLine(Customer customer) {
        // Welcome customer
        String welcome = String.format("Hello %s, would you pass me your shopping cart?",
                customer.getName());
        Console.write(welcome);

        // perform checkout
        ShoppingCart cart = customer.getCart();

        double amountToPay = cart.getTotalPrice(discountStrategy, customer);
        String payinfo = String.format("Let's see, that will be.. %.02f. Cash or card?", amountToPay);
        Console.write(payinfo);
    }
}
