package com.powernode.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: RG
 * @Package: com.powernode.IO
 * @name: Exercise1
 * @Date: 2024/11/27 15:15
 * @Purpose: 目录的递归拷贝
 */
public class Exercise1 {
    public static void main(String[] args) {
        File src = new File("D:\\study\\draft");
        File dest = new File("D:\\study\\gaga\\gaga");
        copy(src, dest);

    }

    /**
     * 拷贝目录的方法
     * @param src
     * @param dest
     */
    private static void copy(File src, File dest) {
        if (src.isFile()) {
            try (FileInputStream in = new FileInputStream(src);
                 FileOutputStream out = new FileOutputStream(dest.getAbsolutePath() + src.getAbsolutePath().substring(8))){
                byte[] bytes = new byte[1024];
                int readCount = 0;
                while ((readCount = in.read(bytes)) != -1) {
                    out.write(bytes, 0, readCount);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        // 创建目标目录
        File newPath = new File(dest.getAbsolutePath() + src.getAbsolutePath().substring(8));
        if (!newPath.exists()) {
            newPath.mkdirs();
        }

        File[] files = src.listFiles();
        for (File f : files) {
//            System.out.println(f.getAbsolutePath());
            copy(f, dest);
        }
    }
}
