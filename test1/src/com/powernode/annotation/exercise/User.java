package com.powernode.annotation.exercise;

/**
 * @Author: 19599
 * @Date: 2024/12/1 18:54
 */
@Table(name = "t_user")
public class User {

    @Column(name = "uid")
    private String id;

    @Column(name = "username")
    private String name;

    @Column(name = "userage", type = "int")
    private int age;

    private String email;

}
