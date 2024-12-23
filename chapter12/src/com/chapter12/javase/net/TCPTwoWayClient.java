package com.chapter12.javase.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @Author: 19599
 * @Date: 2024/12/2 16:31
 *
 * 客户端发送一个图片给服务器，接受服务器返回的消息
 *
 */
public class TCPTwoWayClient {
    public static void main(String[] args) {
        Socket client = null;

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        BufferedReader br = null;

        try {
            InetAddress localHost = InetAddress.getLocalHost();
            int port = 8888;
            client = new Socket(localHost, port);

            // 客服端给服务器端发送文件
            OutputStream outputStream = client.getOutputStream();
            bos = new BufferedOutputStream(outputStream);

            System.out.println("准备发送小狗图片");

            // 一边从硬盘里读，一边再往服务器写
            // 定义一个输入流，读取图片
            bis = new BufferedInputStream(new FileInputStream("D:\\study\\draft\\dog.jpg"));

            byte[] bytes = new byte[1024];
            int readCount = 0;
            while ((readCount = bis.read(bytes)) != -1) {
                bos.write(bytes, 0, readCount);
            }

            // 刷新
            bos.flush();

            // 客户端关闭输出
            client.shutdownOutput();

            System.out.println("小狗图片发送成功");

            // 客户端就收服务器发来的数据
            InputStream inputStream = client.getInputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));

            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
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

            if (bos != null) {
                try {
                    bos.close();
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
