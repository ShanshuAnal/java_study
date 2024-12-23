package com.chapter12.javase.net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author: 19599
 * @Date: 2024/12/2 14:52
 * <p>
 * URL包括四部分
 * 协议  域名/IP地址  端口号  资源路径  资源名称
 * URL是网络中某个资源的地址，某个资源的唯一标识，是可以通过URL真实地定位到资源的
 */
public class URLTest1 {
    public static void main(String[] args) throws MalformedURLException {
        // 创建URL类型的对象
        URL url = new URL("http://www.baidu.com/od.index.html?name=zhangsan&password=123#tip");

        // 获取URL中的信息
        // 使用的协议
        String protocol = url.getProtocol();
        System.out.println(protocol);

        // 资源路径
        String path = url.getPath();
        System.out.println(path);

        // 获取默认端口（HTTP默认80）
        int defaultPort = url.getDefaultPort();
        System.out.println(defaultPort);

        // 获取当前端口号
        int port = url.getPort();
        System.out.println(port);

        // 获取URL中的IP地址
        String host = url.getHost();
        System.out.println(host);

        // 获取URL中准备传输的数据
        String query = url.getQuery();
        System.out.println(query);

        // 获取URL中的锚点
        String ref = url.getRef();
        System.out.println(ref);

        // 获取资源路径 + 数据
        String file = url.getFile();
        System.out.println(file);
    }
}
