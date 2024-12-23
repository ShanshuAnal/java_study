package com.chapter12.javase.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * @Author: 19599
 * @Date: 2024/12/2 14:35
 *
 * java.net.InetAddress类用来封装计算机的IP地址和DNS（没有端口信息）
 * 它包括一个主机名和一个IP地址，是java对IP地址的高层表示
 * 大多数其他网络类都要用这个类，包括Socket、ServerSocket、URL等
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        // 获取本机IP地址和主机名的封装对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        // 获取本机的IP地址
        System.out.println(localHost.getHostAddress());

        // 获取主机名
        System.out.println(localHost.getHostName());

        // 获取指定域名的InetAddress对象
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName.getHostName());
        System.out.println(byName.getHostAddress());
    }
}
