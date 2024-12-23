package com.powernode.collection;

/**
 * @Author: RG
 * @Package: com.powernode.collection
 * @name: Product
 * @Date: 2024/10/16 22:41
 */
public class Product implements MyComparable<Product>{

    private int price;

    public Product() {
    }

    @Override
    public int compareTo(Product o) {

        return price - o.price;
    }

    public Product(int price) {
        this.price = price;
    }



    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
