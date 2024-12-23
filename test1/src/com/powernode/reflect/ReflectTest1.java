package com.powernode.reflect;

import com.powernode.User;
import com.powernode.map.UserDemo;
import org.junit.jupiter.api.Test;

import javax.xml.namespace.QName;
import java.lang.reflect.*;
import java.util.ArrayList;

/**
 * 反射机制（Reflection）是 Java 的一项强大特性，
 * 它允许程序在运行时动态地加载、探索、分析和操作类、方法、字段等对象。
 * 通过反射，Java 程序可以在运行时查询类的信息，甚至动态创建对象、调用方法和访问字段。
 * <p>
 * 反射的核心思想是，在编译时，程序并不需要知道具体的类名、方法名等信息，而是在运行时通过反射来获取和操作这些信息。
 * 1. 反射机制是JDK中的一套类库，这个类库可以帮助我们操作/读取 class字节码文件
 * 2. 后期学习的Java框架，底层都是基于反射机制实现的
 * 3. 反射机制可以让程序更加灵活
 * 4. 最核心的几个类
 *      java.lan.Class：用来获取类的结构信息（如类名、方法、字段等）
 *      java.lan.Constructor: 用来获取类的构造函数
 *      java.lan.Method: 用来获取类的方法
 *      java.lan.Field: 用来获取类的字段
 */
public class ReflectTest1 {
    /**
     * Class<?> 是为了表示一个不确定类型的 Class 对象，它能够保持类型安全，并确保在编译时不会出现类型错误。
     * 使用 Class<?> 可以更灵活地处理不同类型的 Class 对象，同时避免了使用原始类型 Class 时可能出现的类型问题。
     *
     * Class<T> 是一个泛型类，表示某个特定类型的类。
     * 例如，Class<String> 表示 String 类型的 Class 对象，
     * Class<Integer> 表示 Integer 类型的 Class 对象等。
     *
     *
     * 在java中获取Class的三种方式:
     * （1）Class<?> class = Class.forName("完整的全限定类名");
     *  注意：
     *      全限定类名是带有包名的，这是个字符串参数
     *      如果这个类不存在会报异常：java.lang.ClassNotFoundException
     *      这个方法的运行会产生类加载的动作
     *  Class<?> class = Class.forName("java.util.ArrayList");
     *  这个class就表示ArrayList类型，代表硬盘上的ArrayList.class文件
     *
     * (2) Class<?> class = obg.getClass()  通过对象引用调用
     *
     * (3) Class class = 类名.class;
     * Java中的所有类型包括基本数据类型都有 .class属性
     *
     */
    @Test
    public void test1() throws Exception {
        // 1. 获取Class对象
        // （1）通过类名
        Class<ArrayList> class1 = ArrayList.class;
        Class<Integer> integerClass = int.class;

        // （2）通过对象实例.getClass()获取
        UserDemo userDemo = new UserDemo();
        Class<? extends UserDemo> class2 = userDemo.getClass();

        // （3）通过Class.forName("全限定类名")动态加载类
        Class<?> class3 = Class.forName("java.util.ArrayList");

        // （4）获取一个类加载器对象
        // 获取系统类加载器（就是应用类加载器）
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        // 加载类，这个加载过程只是完成了装载和连接，还没做初始化
        // 当这个类被第一次真正使用的时候才做初始化
        Class<?> stringClass = systemClassLoader.loadClass("java.lang.String");
        // 前面的三种方法都是直接完成三步
        // 可以在构造方法里弄个sout验证


        // class1 和 class3 获得都是ArrayList类字节码文件在内存中的地址
        // ArrayList文件只有一份，自然也就相等
        System.out.println(class1 == class3); //true
    }

    /**
     * 获取类的信息
     * @throws ClassNotFoundException
     */
    @Test
    public void test2() throws ClassNotFoundException {
        Class<ArrayList> class1 = ArrayList.class;

        UserDemo userDemo = new UserDemo();
        Class<? extends UserDemo> class2 = userDemo.getClass();

        Class<?> class3 = Class.forName("java.util.ArrayList");


        // 2. 获取类的信息
        // 获取类名
        System.out.println(class2.getName());
        System.out.println(class2.getSimpleName());
        System.out.println("******************");

        // 获取父类
        Class<? super ArrayList> class1Superclass = class1.getSuperclass();
        System.out.println(class1Superclass.getName());
        System.out.println("******************");

        // 获取实现的接口
        Class<?>[] interfaces = class3.getInterfaces();
        for (Class<?> iface : interfaces) {
            System.out.println(iface.getName());
        }


    }

    /**
     *  获取构造参数
     */
    @Test
    public void test3() throws ClassNotFoundException, NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<ArrayList> class1 = ArrayList.class;

        UserDemo userDemo = new UserDemo();
        Class<? extends UserDemo> class2 = userDemo.getClass();

        Class<?> class3 = Class.forName("java.util.ArrayList");

        // 3. 获取构造函数
        // 无参构造函数
        // 已过时
        Constructor<? extends UserDemo> nonArg = class2.getConstructor();
        UserDemo userDemo1 = nonArg.newInstance();
        System.out.println(userDemo1);

        Constructor<? extends UserDemo> constructor = class2.getDeclaredConstructor();
        UserDemo userDemo4 = constructor.newInstance();
        System.out.println(userDemo4);


        // 有参构造
        Constructor<? extends UserDemo> param = class2.getDeclaredConstructor(String.class, int.class);
        UserDemo userDemo2 = param.newInstance("zhangsan", 12);
        System.out.println(userDemo2);

        Constructor<? extends UserDemo> param1 = class2.getDeclaredConstructor(String.class, int.class, int.class);
        UserDemo userDemo3 = param1.newInstance("zhaosi", 1, 1);
        System.out.println(userDemo3);
    }

    /**
     * 获取方法
     */
    @Test
    public void test4() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<ArrayList> class1 = ArrayList.class;

        UserDemo userDemo = new UserDemo();
        Class<? extends UserDemo> class2 = userDemo.getClass();

        Class<?> class3 = Class.forName("java.util.ArrayList");

        UserDemo userDemo2 = new UserDemo("zhangsan", 12);

        // 4. 获取方法并调用方法
        // 获取所有方法
        Method[] declaredMethods = class2.getDeclaredMethods();
        for (Method method : declaredMethods) {
            // public java.lang.String com.powernode.map.UserDemo.getName()
            System.out.println("方法：" + method);

            // 方法修饰符
            System.out.println("方法修饰符: " + Modifier.toString(method.getModifiers()));

            // 方法返回类型
            System.out.println("方法返回类型: " + method.getReturnType().getSimpleName());

            // 方法名
            System.out.println("方法名: " + method.getName());

            // 参数列表
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println("参数：" + parameter.toString());
                System.out.print("参数类型" + parameter.getType().getSimpleName());
                System.out.println("， 参数名" + parameter.getName());
            }

            System.out.println("*************");
        }

        Method getName = class2.getMethod("getName");
        Object haha = getName.invoke(userDemo2);
        System.out.println(haha);

        Method setName = class2.getMethod("setName", String.class);
        //      返回值    方法名          对象              参数
        Object haha1 = setName.invoke(userDemo2, "zhangsan1");
        Object newName = getName.invoke(userDemo2);
        System.out.println(newName);

        // 获取私有方法
        Method getString = class2.getDeclaredMethod("getString", String.class);
        getString.setAccessible(true);
        Object haha2 = getString.invoke(userDemo2, "zhangsan2");
        Object age = getName.invoke(userDemo2);
        System.out.println(userDemo2);

    }

    /**
     * 获取字段
     */
    @Test
    public void test5() throws Exception {

        Class<ArrayList> class1 = ArrayList.class;

        UserDemo userDemo = new UserDemo();
        Class<? extends UserDemo> class2 = userDemo.getClass();

        Class<?> class3 = Class.forName("java.util.ArrayList");

        UserDemo userDemo2 = new UserDemo("zhangsan", 12);
        UserDemo userDemo1 = new UserDemo("lisi", 11);


        // 5. 获取字段并操作字段 通过反射，可以访问和修改类的字段（包括私有字段）。
        // 获取所有public字段 只能获取到public的
        Field[] fields = class2.getFields();
        for (Field field : fields) {
//            System.out.println(field.getName());
        }

        // 获取所有字段
        Field[] declaredFields = class2.getDeclaredFields();
        for (Field field : declaredFields) {
            // private java.lang.String com.powernode.map.UserDemo.name
            System.out.println("字段：" + field);

            // 修饰符
            int modifiers = field.getModifiers();
            String string = Modifier.toString(modifiers);
            System.out.println("修饰符：" + string);

            // 属性名
            // name
            System.out.println("属性名: " + field.getName());

            // 属性类型
            Class<?> type = field.getType();
            // class java.lang.String
            System.out.println("属性类型:" + type);

            // String
            System.out.println("SimpleName:" + type.getSimpleName());

            // java.lang.String
            System.out.println("Name:" + type.getName());
            // java.lang.String
            System.out.println("TypeName:" + type.getTypeName());

            // java.lang
            System.out.println("PackageName:" + type.getPackageName());

            // java.lang.String
            System.out.println("CanonicalName:" + type.getCanonicalName());
        }
        System.out.println("获取指定字段：");

        // 获取指定 字段
        Field name = class2.getDeclaredField("name");
        System.out.println("属性：" + name.getName());
        // 如果是私有的，设置可访问
        name.setAccessible(true);
        Object o = name.get(userDemo2);
        System.out.println(o);

        // 获取getName()方法
        Method getName = class2.getMethod("getName");

        // 设置字段值  三要素：给哪个对象的哪个属性赋什么值
        name.set(userDemo2, "zhangsan3");
        System.out.println(name.get(userDemo2));

        Object haha4 = getName.invoke(userDemo2);
        System.out.println(haha4);


        name.set(userDemo1, "lisi1");
        System.out.println(name.get(userDemo1));

        Object invoke = getName.invoke(userDemo1);
        System.out.println(invoke);




        System.out.println(userDemo1);
    }
}
