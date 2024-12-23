package com.powernode.decorator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: RG
 * @Package: com.powernode.decorator
 * @name: LogDecorator
 * @Date: 2024/11/27 19:34
 */
public class LogDecorator extends FlyableDecorator{

    public LogDecorator(Flyable animal) {
        super(animal);
    }

    @Override
    public void fly() {
        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(sdf.format(now) + ":take off");

        super.fly();

        now = new Date();
        System.out.println(sdf.format(now) + ":land");

    }
}
