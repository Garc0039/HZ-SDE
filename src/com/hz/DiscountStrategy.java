package com.hz;

import products.Product;

public interface DiscountStrategy {

    public double getDiscount(Customer customer, int index);
}
