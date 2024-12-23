package com.powernode;

/**
 * @Author: Ryan Gosling Literally me
 * @Package: com.powernode
 * @name: AnonymousClasses
 * @Date: 2024/9/21 13:59
 */
public class AnonymousClasses {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.conn(new Printer());

        // 1.完成了匿名内部类的定义
        // 2.实例化了一个匿名内部类的对象
        computer.conn(new Usb() {
            @Override
            public void read() {
                System.out.println("reading!!!!!");
            }

            @Override
            public void write() {
                System.out.println("writing!!!!!!");
            }
        });
    }
}

class Computer {

    public void conn(Usb usb) {
        usb.read();
        usb.write();
    }
}

interface Usb {

    void read();

    void write();
}

class Printer implements Usb {

    @Override
    public void read() {
        System.out.println("reading!");
    }

    @Override
    public void write() {
        System.out.println("writing!");
    }
}

