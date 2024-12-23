package com.powernode;

/**
 * @Author: RG
 * @Package: com.powernode
 * @name: Season
 * @Date: 2024/10/15 22:30
 * <p>
 *
 *
 * 枚举类因为默认继承了Enum 因而不能继承其他类 但是可以实现接口
 *          第一种实现：在枚举类中实现
 *          第二种实现：让每一个枚举值都实现接口
 */



public enum Season implements Eatable{
    // 枚举值必须放在最前面
    // 这边就是在调用有参构造函数 实际上就可以把这四个看成四个Season类型的对象
    SPRING("春","111") {
        @Override
        public void eat() {
            System.out.println("春天也可以在每个枚举值里面实现接口");
        }

        @Override
        public int apply(int a, int b) {
            return a+ b;
        }
    },
    SUMMER("夏","222"){
        @Override
        public void eat() {
            System.out.println("夏天也可以在枚举值里面实现接口");
        }

        @Override
        public int apply(int a, int b) {
            return a - b;
        }
    },
    AUTUMN("秋","333") {
        @Override
        public int apply(int a, int b) {
            return a * b;
        }
    },
    WINTER("冬","444") {
        @Override
        public int apply(int a, int b) {
            return a / b;
        }
    };

    private final String name;
    private final String desc;

    @Override
    public void eat() {
        System.out.println(this.getName() + ":吃就完了");
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public abstract int apply(int a, int b);

    // 构造方法 是私有的
    // 枚举的构造方法不能使用new来调用
    // 枚举类的构造方法只能在本类中使用
    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
        System.out.println("构造函数");
    }

    // 静态代码块
    // 静态代码块是在类被加载时执行的一段代码，它在类的生命周期中只会执行一次
    static {
        System.out.println("静态代码块");
    }

    // 构造代码块
    static {
        System.out.println("构造代码块");
    }

    // 静态变量
    public final static int A = 1000;

    // 静态方法
    public static int getA() {
        System.out.println("静态方法");
        return A;
    }

    // 实例变量
    private final int a = 10;

    // 实例方法
    public int geta() {
        System.out.println("实例方法");
        return a;
    }


}