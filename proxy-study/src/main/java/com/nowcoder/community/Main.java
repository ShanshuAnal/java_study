package com.nowcoder.community;


import net.sf.cglib.proxy.Enhancer;

/**
 * @Author: 19599
 * @Date: 2025/9/18 4:31
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird();

        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(Bird.class.getClassLoader());
        enhancer.setSuperclass(Bird.class);
        enhancer.setCallback(new MyMethodInteceptor());

        Bird birdProxy = (Bird) enhancer.create();
        birdProxy.fly();
        birdProxy.eat();

    }
}