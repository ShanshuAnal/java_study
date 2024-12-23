package com.powernode.IO;

import com.powernode.map.UserDemo;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: ObjectInputStreamTest
 * @Date: 2024/11/26 16:07
 */
public class ObjectInputStreamTest {
    /**
     * ObjectInputStream 对象流（对象字节输入流）
     * 反序列化过程，将文件中对象字节序列或辅导内存中，变成java对象
     */
    @Test
    public void test1() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("../object"))){
            List<Date> dateList = (List<Date>) ois.readObject();
            Iterator<Date> it = dateList.iterator();
            while (it.hasNext()) {
                Date next = it.next();
                System.out.println(next);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     */
    @Test
    public void test2() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("../object"))){
            UserDemo userDemo = (UserDemo) ois.readObject();
            System.out.println(userDemo);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
