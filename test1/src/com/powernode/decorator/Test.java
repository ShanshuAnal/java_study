package com.powernode.decorator;

import java.io.PrintWriter;

/**
 * @Author: RG
 * @Package: com.powernode.decorator
 * @name: Test
 * @Date: 2024/11/27 16:56
 */
public class Test {
    public static void main(String[] args) {
        TimerDecorator fd = new TimerDecorator(new Cat());
        fd.fly();

        LogDecorator ld = new LogDecorator(new Cat());
        ld.fly();


    }
}
