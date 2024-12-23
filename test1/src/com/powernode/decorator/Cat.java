package com.powernode.decorator;

/**
 * @Author: RG
 * @Package: com.powernode.decorator
 * @name: Cat
 * @Date: 2024/11/27 16:55
 */
public class Cat implements Flyable{
    @Override
    public void fly() {
        System.out.println("cat flies");
    }
}
