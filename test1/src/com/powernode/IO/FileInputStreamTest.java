package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: FileInputStreamTest
 * @Date: 2024/11/21 19:53
 */
public class FileInputStreamTest {
    /**
     * 文件字节输入流，负责读
     * 是一个万能流，任何文件都能读，但还是建议读二进制文件
     * 可以读普通文本，只不过一次只能读一个字节，容易出现乱码<p>
     * 常用构造方法：
     * (1) FileInputStream(File file)
     * <p>
     * (2) FileInputStream(FileDescriptor fdObj)
     * <p>
     * (3) FileInputStream(String name) name字符串是文件路径
     * 常用方法
     * (1) int read(); 调取一次read()就读取一个字节，返回独到的字节本身
     * 如果什么也读不到，就返回-1
     * (2) int read(byte[] b);  一次最多读到byte.length个字节，只要文件
     * 内容足够多，返回值是读取到的字节数量，如果没有读到任何数据，则返回-1
     * (3) int read(byte[] b, int offset, int len); 一次读取len个字节，
     * 将读到的数据从byte数组的offset位置开始放
     * (4) void close(); 关闭流
     * (5) int available(); 获取流中剩余的估计字节数
     * (6) long skip(long n); 跳过n个字节
     */
    @Test
    public void test1() {
        FileInputStream in = null;
        try {
            in = new FileInputStream("D:\\study\\draft\\file1.txt");
            int readBack = 0;
            while ((readBack = in.read()) != -1) {
                System.out.println(readBack);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    @Test
    public void test2() {
        FileInputStream in = null;
        try {
            in = new FileInputStream("D:\\study\\draft\\file1.txt");
            byte[] nums = new byte[1024];

            StringBuilder sb = new StringBuilder();

            int read = 0;
            while ((read = in.read(nums)) != -1) {
                System.out.println(read);
                System.out.println(Arrays.toString(nums));
                System.out.println(new String(nums, 0, read));
                sb.append(new String(nums, 0, read));
            }
            System.out.println(sb);


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test3() {
        FileInputStream in = null;
        try {
            in = new FileInputStream("D:\\study\\draft\\file1.txt");

            int read = in.read();
            System.out.println(read);

            int available = in.available();
            System.out.println(available);

            long skip = in.skip(2);
            System.out.println(skip);

            read = in.read();
            System.out.println(read);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test4() {
        FileInputStream in = null;
        try {
            in = new FileInputStream("D:\\study\\draft\\file1.txt");

            // 一次性读完
            byte[] bytes = new byte[in.available()];
            int read = in.read(bytes);
            System.out.println(read);
            System.out.println(new String(bytes, 0, read));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
