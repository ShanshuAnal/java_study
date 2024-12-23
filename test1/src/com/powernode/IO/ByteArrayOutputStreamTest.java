package com.powernode.IO;

import com.powernode.Address;
import com.powernode.User;
import com.powernode.collection.UserClone;
import com.powernode.map.UserDemo;
import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: ByteArrayOutputStreamTest
 * @Date: 2024/11/27 20:03
 */
public class ByteArrayOutputStreamTest {

    /**
     * 向内存中字节数组写数据
     */
    @Test
    public void test1() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        baos.write(1);
        baos.write(1);
        baos.write(1);

        byte[] bytes = baos.toByteArray();
        for (byte b : bytes) {
            System.out.println(b);
        }
    }

    /**
     * 装饰器设计模式
     * 包装流和节点流是可以随意组合的
     * ObjectInputStream（包装流） 和 ByteArrayOutputStream（节点流）进行组合
     */
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        ObjectOutputStream oos = new ObjectOutputStream(baos);


        // 开始写
        oos.writeInt(1);
        oos.writeBoolean(true);
        oos.writeUTF("hahahah");
        oos.writeUTF("hahahah");
        oos.writeObject(new UserDemo());


        // 使用了包装流就要手动刷新
        oos.flush();

        byte[] bytes = baos.toByteArray();
//        for (byte b : bytes) {
//            System.out.println(b);
//        }

        // 使用BytesArrayInputStream将bytes数组中的数据恢复
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);

        System.out.println(ois.readInt());
        System.out.println(ois.readBoolean());
        System.out.println(ois.readUTF());
        System.out.println(ois.readUTF());
        System.out.println(ois.readObject());

    }

    /**
     * 深克隆
     * 1. 实现Cloneable接口的clone()方法，默认是浅克隆，深克隆要重写
     * 2. 通过ObjectOutputStream序列化 和 ObjectInputStream反序列化 
     * 3. ByteArrayOutputStream 和 ByteArrayInputStream 直接复制的对象就是一个深克隆
     */
    @Test
    public void test3() throws IOException, ClassNotFoundException {
        Address address = new Address("nanjing", "gulou");
        UserClone user1 = new UserClone("zhangsan", 11, address);

        // 将对象写到数组中
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(user1);

        oos.flush();

        // 从byte数组中读取数据，恢复成Java对象
        byte[] bytes = new byte[1024];
        int readCount = 0;
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);

        UserClone userClone = (UserClone) ois.readObject();
//        userClone.setAddress(new Address("beijing", "chaoyang"));
        System.out.println("看看transient street有没有用：");
        System.out.println(user1);
        System.out.println(userClone);

        System.out.println("看看深克隆也没有成功");
        userClone.setAddress(new Address("beijing", "chaoyang"));
        System.out.println(user1);
        System.out.println(userClone);

    }
}
