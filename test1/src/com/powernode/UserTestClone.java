package com.powernode;

/**
 * @author 19599
 * clone()
 * 1. 作用
 *      对象拷贝，通常在开发中需要保护原对象数据结构。通常复制一份，生成一个新的对象，对新对象进行操作
 * 2. Object类中的默认实现
 *      protected native Object clone() throws CloneNotSupportedException;
 *      受保护的方法，只能自己、子类或者同包中的类使用
 *      本地方法（naive）
 *      底层调用C++程序已经可以完成对象的创建了
 * 3. 如何调用
 *      在子类中重写clone()方法
 * 4. 凡是参加克隆的对象，必须实现一个标志接口
 *      implements Cloneable
 *      接口包括两大类:
 *          一类是：起到标志的作用，标志型接口
 *          二类是：普通接口
 * 5. 浅拷贝 深拷贝
 *      浅拷贝成因：类的属性保存的是地址
 *      解决方法：重写克隆方法，搞一个毫不相关的复制体
 * */

public class UserTestClone {
    public static void main(String[] args) throws CloneNotSupportedException {

        Address address = new Address("Beijing","Haidian");
        User user = new User("zhang", address);


        Object o = user.clone();
        // 向下转型
        User user1 = (User) o;
        user1.getAddress().setCity("Tokyo");
        System.out.println(user);
        System.out.println(user1);
        System.out.println(args.length );
    }
}