package com.chapter12.javase.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @Author: 19599
 * @Date: 2024/12/2 17:23
 * <p>
 * UDP编程
 * 接受方
 */
public class Receiver {
    public static void main(String[] args) throws Exception {
        int port = 8888;
        DatagramSocket ds = new DatagramSocket(port);

        byte[] bytes = new byte[1024 * 64];
        // 准备一个数据包，用来接收发送方的信息
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        // 服务器等待客户端发送数据
        ds.receive(dp);

        // 执行到这，说明服务器已经完全接受了客户端的信息
        // 从包中取出数据
        String msg = new String(bytes, 0, dp.getLength());
        System.out.println(msg);

        ds.close();
    }
}
