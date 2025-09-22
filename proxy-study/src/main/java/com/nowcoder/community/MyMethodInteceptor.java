package com.nowcoder.community;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author: 19599
 * @Date: 2025/9/18 4:32
 * @Description:
 */
public class MyMethodInteceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println(method.getName() +  "'s before");
        Object res = methodProxy.invokeSuper(o, args);
        System.out.println(method.getName() +  "'s after");
        return res;
    }
}
