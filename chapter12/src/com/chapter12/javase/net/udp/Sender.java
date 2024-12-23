package com.chapter12.javase.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @Author: 19599
 * @Date: 2024/12/2 17:21
 *
 * 演示UDP编程
 * 发送方
 *
 */
public class Sender {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();

        byte[] bytes = "helloooo".getBytes();
        InetAddress localHost = InetAddress.getLocalHost();
        int port = 8888;

        // 创建数据包
        DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length, localHost, port);

        // 发送消息
        ds.send(dp);

        // 关闭
        ds.close();

    }
}
