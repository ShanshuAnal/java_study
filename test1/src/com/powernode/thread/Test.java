package com.powernode.thread;

import com.powernode.User;

/**
 * @Author: 19599
 * @Date: 2024/12/7 17:28
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        UserTest zsz = new UserTest("zsz", 1);

        UserTest clone = zsz.clone();

        clone.setAge(123);

        System.out.println(zsz);
    }
}
