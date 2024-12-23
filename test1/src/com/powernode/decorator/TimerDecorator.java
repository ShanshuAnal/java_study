package com.powernode.decorator;

/**
 * @Author: RG
 * @Package: com.powernode.decorator
 * @name: FlyableDecorator
 * @Date: 2024/11/27 19:16
 */
public class TimerDecorator extends FlyableDecorator{

    public TimerDecorator(Flyable animal) {
        super(animal);
    }

    @Override
    public void fly() {
        long begin = System.currentTimeMillis();
        super.fly();
        long end = System.currentTimeMillis();
        System.out.println("time :" + (end - begin));
    }
}
