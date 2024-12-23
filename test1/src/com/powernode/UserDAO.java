package com.powernode;

import exception.IllegalAgeException;
import exception.IllegalNameException;


public class UserDAO {
    private String name;
    private int age;

    public UserDAO(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public UserDAO() {
    }

    public void save(String name, int age) throws IllegalNameException, IllegalAgeException {
        if (name.length() < 6 || name.length() > 12) {
            throw new IllegalNameException("名字异常");
        }
        if (age < 18 ) {
            throw new IllegalAgeException("年龄不合法");
        }
        System.out.println("saved");
    }

    public static void main(String[] args){
        UserService userService = new UserService();
        try {
            userService.register("zzzzjz", 18);
            System.exit(0);
        } catch (Exception e) {
            e.getMessage();
            throw new RuntimeException(e);
        } finally {
            System.out.println("finally");
        }
    }
}

class UserService {
    public void register(String name, int age) throws Exception{
        System.out.println("registering");
        UserDAO userDAO = new UserDAO();
            userDAO.save(name, age);
    }
}
