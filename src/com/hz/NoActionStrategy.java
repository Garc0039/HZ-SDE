package com.hz;

public class NoActionStrategy implements DiscountStrategy {
    @Override
    public double getDiscount(Customer customer, int index) {
        double discount = 0.0;

        if(customer.isRegular()) {
            discount = 0.15;
        } else {
            discount = 0.0;
        }

        return 1 - discount;
    }
}
