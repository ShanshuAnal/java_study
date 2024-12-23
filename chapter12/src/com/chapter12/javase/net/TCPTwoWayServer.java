package com.chapter12.javase.net;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: 19599
 * @Date: 2024/12/2 16:32
 *
 * 服务器端：接受客户端发来的图片，回复消息给客户端
 */
public class TCPTwoWayServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket server = null;
        BufferedInputStream bis = null;
        BufferedWriter bw = null;
        BufferedOutputStream bos = null;

        try {
            // 先启动服务器，设置对应端口
            int port = 8888;
            serverSocket = new ServerSocket(8888);

            System.out.println("服务器正在启动！");
            System.out.println("服务器启动成功，端口为：" + port);

            // 开始接受客户端请求
            server = serverSocket.accept();


            // 接受客户端发来的文件
            InputStream inputStream = server.getInputStream();
            bis = new BufferedInputStream(inputStream);

            bos = new BufferedOutputStream(new FileOutputStream("dog.jpg"));

            // 开始读
            byte[] bytes = new byte[1024];
            int readCount = 0;
            while ((readCount = bis.read(bytes)) != -1) {
                // 把客户端发来的文件保存在本地服务器中
                // 还要定义一个本地IO输出流
                bos.write(bytes, 0, readCount);
            }
            // 刷新
            bos.flush();

            // 服务器关闭输入
            server.shutdownInput();


            System.out.println("小狗图片保存成功");


            // 给客户端发送数据
            OutputStream outputStream = server.getOutputStream();
            bw = new BufferedWriter(new OutputStreamWriter(outputStream));

            bw.write("我收到啦");

            // 刷新
            bw.flush();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (server != null) {
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
