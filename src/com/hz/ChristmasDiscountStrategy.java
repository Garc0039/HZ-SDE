package com.hz;

import products.Product;

public class ChristmasDiscountStrategy implements DiscountStrategy {
    @Override
    public double getDiscount(Customer customer, int index) {

        double discount = 0.0;

        boolean isFirstProduct = index == 0;

        // on Christmas Eve, 1st product 20%, the next 12.5% discount

        if(isFirstProduct) {
            discount = .20;
        } else {
            discount = .125;
        }

        return 1 - discount;
    }
}
