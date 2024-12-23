package com.chapter12.javase.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: 19599
 * @Date: 2024/12/2 15:45
 * 使用java中的Socket实现单向通信，属于TCP协议，属于TCP编程
 * 这个类是客户端
 */
public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        BufferedReader br = null;

        try {
            // 先启动服务器，设置对应端口
            int port = 8888;
            serverSocket = new ServerSocket(8888);

            System.out.println("服务器正在启动！");
            System.out.println("服务器启动成功，端口为：" + port);

            // 开始接受客户端请求
            clientSocket = serverSocket.accept();

            // 客户端发消息给服务端，服务端要接受消息，所以是输入流
            InputStream inputStream = clientSocket.getInputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));

            char[] chars = new char[1024];
            int readCount = 0;
            while ((readCount = br.read(chars)) != -1) {
                System.out.println(new String(chars, 0, readCount));
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭服务端套接字
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
