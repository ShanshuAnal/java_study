package com.powernode.reflect;

/**
 * 类加载的过程
 * 1. 装载
 *    类加载器负责将类的class文件读入内存
 *    （1） 启动类加载器负责加载核心类库
 *    （2） 平台类加载器负责加载Java扩展类、非核心类
 *    （3） 应用类加载器负责加载程序员编写的程序
 * 2. 连接
 *    （1） 验证
 *     确保加载类的信息符合JVM规范
 *    （2） 准备
 *     正式为静态变量在方法区中开辟存储空间 并设置默认值
 *    （3） 解析
 *     将虚拟机常量池内的符号引用替换为直接引用（地址）的过程
 * 3. 初始化
 *     静态变量赋值，静态代码块执行
 *
 *
 *
 * @author 19599
 */
public class ReflectTest5 {
    public static void main(String[] args) {

    }
}