package com.chapter12.javase.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: 19599
 * @Date: 2024/12/2 15:12
 *  腾讯天气 爬虫
 */
public class URLTest2 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://tianqi.qq.com");
        InputStream inputStream = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));

//        String s = null;
//        while ((s = br.readLine()) != null) {
//            System.out.println(s);
//        }
//
        char[] chars = new char[1024];
        int readCount = 0;
        while ((readCount = br.read(chars)) != -1) {
            System.out.println(new String(chars, 0, readCount));
        }

        br.close();
    }
}
