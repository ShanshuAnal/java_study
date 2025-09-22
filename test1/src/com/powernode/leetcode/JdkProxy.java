package com.powernode.leetcode;

import com.powernode.decorator.Bird;
import com.powernode.decorator.Flyable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: 19599
 * @Date: 2025/9/18 3:50
 * @Description:
 */
public class JdkProxy {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Flyable flyable = (Flyable) Proxy.newProxyInstance(bird.getClass().getClassLoader(),
                bird.getClass().getInterfaces(),
                new MyInvocationHandler(bird));
        flyable.fly();

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        lock.lock();

        condition.signal();

        condition.signal();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 1L, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Flyable target;

    public MyInvocationHandler(Flyable flyable) {
        this.target = flyable;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object res = method.invoke(target, args);
        System.out.println("after");
        return res;
    }
}
