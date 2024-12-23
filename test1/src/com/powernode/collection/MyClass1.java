package com.powernode.collection;

/**
 * @Author: RG
 * @Package: com.powernode.collection
 * @name: MyClass1
 * @Date: 2024/10/16 22:22
 */
public class MyClass1<NameType, AgeType> {
    private NameType name;
    private AgeType age;

    public MyClass1() {
    }

    public MyClass1(NameType name, AgeType age) {
        this.age = age;
        this.name = name;
    }

    public NameType getName() {
        return name;
    }

    public void setName(NameType name) {
        this.name = name;
    }

    public AgeType getAge() {
        return age;
    }

    public void setAge(AgeType age) {
        this.age = age;
    }
}
