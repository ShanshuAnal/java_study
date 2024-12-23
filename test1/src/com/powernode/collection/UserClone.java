package com.powernode.collection;

import com.powernode.Address;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: RG
 * @Package: com.powernode.collection
 * @name: UserClone
 * @Date: 2024/11/27 20:36
 */
public class UserClone implements Serializable {
    @Serial
    private static final long serialVersionUID = -2076586287607244047L;
    private String name;
    private int age;
    private Address address;

    public UserClone() {
    }

    public UserClone(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserClone{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserClone userClone = (UserClone) o;
        return age == userClone.age && Objects.equals(name, userClone.name) && Objects.equals(address, userClone.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, address);
    }


}
