package com.hz;

import products.Product;

public class BlackFridayDiscountStrategy implements DiscountStrategy {

    @Override
    public double getDiscount(Customer customer, int index) {

        double discount = 0.0;

        if(customer.getCart().size() <= 8) {
            discount = customer.getCart().size() * 0.1;
        } else {
            discount = 0.8;
        }


        return 1 - discount;
    }
}
