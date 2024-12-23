package com.powernode.decorator;

/**
 * @Author: RG
 * @Package: com.powernode.decorator
 * @name: FlyableDecorator
 * @Date: 2024/11/27 19:37
 * 装饰者和被装饰者属于聚合关系
 */
public class FlyableDecorator implements Flyable{

    private Flyable flyable;

    public FlyableDecorator(Flyable flyable) {
        this.flyable = flyable;
    }

    @Override
    public void fly() {
        flyable.fly();
    }
}
