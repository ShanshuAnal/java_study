package com.powernode.collection;

/**
 * @Author: RG
 * @Package: com.powernode.collection
 * @name: Order
 * @Date: 2024/10/16 23:03
 */
public class Order<T> implements MyComparable<Order<T>>{
    private int price;

    public Order() {
    }

    public Order(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Order<T> t) {
        return price - t.getPrice();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
