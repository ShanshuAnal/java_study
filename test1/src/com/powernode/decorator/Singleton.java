package com.powernode.decorator;

/**
 * @Author: 19599
 * @Date: 2024/12/30 23:25
 */
public class Singleton {
    private Singleton(){}

    public static Singleton getInstance() {
        return HolderClass.instance;
    }

    // 静态内部类
    private static class HolderClass {
        private final static Singleton instance = new Singleton();
    }

    public void get() {
        System.out.println(1);
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        instance.get();
    }
}