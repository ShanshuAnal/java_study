package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: PrintStreamTest
 * @Date: 2024/11/26 22:24
 */
public class PrintStreamTest {
    /**
     * PrintStream 打印流(专门负责打印的流，字节形式)，将内容打印到文件或外部设施
     *
     * @常用方法： print(Type x)
     * println(Type x)
     * @优点： 可以直接输出各种数据类型、自动刷新和自动换行、支持字符串转义、自动编码
     * @格式化输出： printf()
     * %s 字符串
     * %d 整数
     * %f 小数（%.2f 表示保存两位小数）
     * %c 字符
     */
    @Test
    public void test1() {
        try (PrintStream ps = new PrintStream("../file3.txt")) {
            ps.print(false);
            ps.println(12313);
            ps.print(1.2f);
            ps.println("\\asdasd\\");
            ps.println("\"asdasd\\");

            String name = "zs";
            double score = 98.3;
            ps.printf("name: %s, score: %.2f", name, score);


//            支持自动刷新
//            ps.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * PrintStream(String name)
     * PrintStream(OutputStream os)
     */
    @Test
    public void test2() {
        try (PrintStream ps = new PrintStream(new FileOutputStream("../file4.txt"))) {
            ps.print(false);
            ps.println(12313);
            ps.print(1.2f);
            ps.println("\\asdasd\\");
            ps.println("\"asdasd\\");

            String name = "zs";
            double score = 98.3;
            ps.printf("name: %s, score: %.2f", name, score);

            ps.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
