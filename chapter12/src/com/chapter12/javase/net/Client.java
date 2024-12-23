package com.chapter12.javase.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: 19599
 * @Date: 2024/12/2 15:43
 * <p>
 * 使用java中的Socket实现单向通信，属于TCP协议，属于TCP编程
 * 这个类是客户端
 */
public class Client {
    public static void main(String[] args) {
        Socket client = null;
        BufferedWriter bw = null;

        try {
            // 获取本地主机
            InetAddress localHost = InetAddress.getLocalHost();

            // 创建客户端Socket，指定服务器的IP地址和端口号
            int port = 8888;
            client = new Socket(localHost, port);

            // 客户端请求服务端，此时客户端向服务端发消息
            // 客户端为输出流，服务器端为输入流
            OutputStream outputStream = client.getOutputStream();
            bw = new BufferedWriter(new OutputStreamWriter(outputStream));

            while (true) {
                Scanner scanner = new Scanner(System.in);
                String message = scanner.next();
                bw.write(message);

                // 刷新
                bw.flush();
                // 延迟效果
                Thread.sleep(1000);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
