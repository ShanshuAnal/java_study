package com.powernode.decorator;

/**
 * @Author: RG
 * @Package: com.powernode.decorator
 * @name: Bird
 * @Date: 2024/11/27 16:56
 */
public class Bird implements Flyable{
    @Override
    public void fly() {
        System.out.println("bird flies");
    }
}
