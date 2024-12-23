package com.powernode.IO;

import com.powernode.map.UserDemo;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: ObjectOutputStreamTest
 * @Date: 2024/11/26 16:08
 */
public class ObjectOutputStreamTest {
    /**
     * ObjectOutputStream 对象流，对象字节输出流
     * 1. 他的租用是完成对象的序列化过程
     * 2. 它可以将JVM当中的对象序列化到文件或网络中
     * 3. 序列化serial：将Java对象转化为字节序列的过程，字节序列可以在网络中传输
     */
    @Test
    public void test1() {
        try (ObjectOutputStream  oos = new ObjectOutputStream(new FileOutputStream("../object"))){
            Date date = new Date();
            oos.writeObject(date);

            oos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2() {
        try (ObjectOutputStream  oos = new ObjectOutputStream(new FileOutputStream("../object"))){
            Date date1 = new Date();
            Date date2 = new Date();
            Date date3 = new Date();
            Date date4 = new Date();
            Date date5 = new Date();

            List<Date> list = new ArrayList<>();
            list.add(date1);
            list.add(date2);
            list.add(date3);
            list.add(date4);
            list.add(date5);

            oos.writeObject(list);

            oos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 凡事要参加序列化和反序列化的自定义类型，都要实现接口 Serializable，
     * 这是一个标志接口，没有任何方法，只起到标记的作用
     *
     * 当java程序中，类实现了Serializable接口，编译器会给该类添加一个“序列化版本号”SerialVersionUID
     * 序列化版本号的作用：
     *      在Java语言中是如何区分class版本的
     *      1. 类的名字
     *      2. 序列化版本号
     * 可以将序列化版本号规定死，以避免由于后期修改而出现的反序列化报错
     *
     * java.io.InvalidClassException: com.powernode.map.UserDemo;
     * local class incompatible:
     *          stream classdesc serialVersionUID = -3071790841302615925, (更改前的UserDemo序列版本号)
     *          local class serialVersionUID      = -5452095951744448624  (更改后的UserDemo序列版本号)
     *
     *
     */
    @Test
    public void test3() {
        try (ObjectOutputStream  oos = new ObjectOutputStream(new FileOutputStream("../object"))){
            UserDemo user = new UserDemo("zs", 1, 112121);
            System.out.println(user);

            oos.writeObject(user);

            oos.writeBoolean(false);
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
