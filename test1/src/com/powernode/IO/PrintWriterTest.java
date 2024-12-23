package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: PrintWriterTest
 * @Date: 2024/11/26 22:24
 */
public class PrintWriterTest {
    /**
     * PrintWriter 专门负责打印的流（字符形式）
     * 需要手动刷新你flush，可以在构造方法里面设置为true，这样就不用手动刷新了
     *
     * PrintWriter 比 PrintStream 多一个构造方法
     *      PrintWriter(OutputStream)
     *      PrintWriter(Writer)
     */
    @Test
    public void test1() {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("../file4.txt"), true)){
            pw.println("wqeqwe");
            pw.println("w12312321312");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void test2() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("../file4.txt"))){
            pw.println("wqeqwe");
            pw.println("w12312321312");

            pw.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
