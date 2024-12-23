package com.powernode.IO;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: FileTest
 * @Date: 2024/11/27 14:13
 */
public class FileTest {
    /**
     * File类
     * 1. File 是路径的抽象表达方式
     * 2. File类和IO流没有继承关系，父类是Object，通过File不能完成文件的读和写
     * 3. File可能是一个文件，也可能是一个目录
     */
    @Test
    public void test1() throws IOException {
        File file = new File("D:\\study\\draft\\fff");

        // 存不存在
        System.out.println(file.exists());

        // 不存在就以文件的形式创建出来
        if (!file.exists()) {
//            file.createNewFile();
        }

        // 不存在以目录形式创建出来
        if (!file.exists()) {
            file.mkdir();
        }

        File file1 = new File("D:\\study\\draft\\a\\b\\b");
        if (!file1.exists()) {

            file1.mkdirs();
        }

    }

    @Test
    public void test2() {
        // 删除
        File file = new File("D:\\study\\draft\\a\\b\\b");
        if (file.exists()) {
            file.delete();
        }

        // 获取绝对路径
        File file1 = new File("file.txt");
        System.out.println(file1.getAbsolutePath());

        // 获取名字
        System.out.println(file1.getName());

        // 获取父路径
        System.out.println(file.getParent());

        // 判断是否是绝对路径
        System.out.println(file.isAbsolute());
        System.out.println(file1.isAbsolute());

        // 判断是目录还是文件
        File file2 = new File("D:\\study\\draft\\file1.txt");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());

    }

    @Test
    public void test3() {
        File file = new File("D:\\study\\draft\\file1.txt");
        // 判断是否是隐藏文件
        System.out.println(file.isHidden());

        // 获取文件的最后修改时间
        long l = file.lastModified();
        Date date = new Date(l);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println(sdf.format(date));

        // 获取文件大小，总字节数
        System.out.println(file.getName() + "的总字节数:" + file.length());


        // 重命名
        File orignal = new File("D:\\study\\draft\\bbb");
        File dest = new File("ccc");
        dest.renameTo(orignal);

    }

    @Test
    public void test4() {
        File file = new File("D:\\study\\draft");

        // 获取所有子文件 包括子目录
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f);
        }

        System.out.println("****************************");
        // 过滤
        File[] files1 = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("txt");
            }
        });

        for (File f : files1) {
            System.out.println(f);
        }

    }
}
