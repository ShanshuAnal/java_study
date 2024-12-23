package com.powernode;

/**
 * @author 19599
 */
public class User implements Cloneable{
    private String name;

    private Address address;

    public User() {}

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    // 姓名一样 家庭住址一样
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof User) {
            User user = (User) obj;
            if (user.getName().equals(this.name) && user.getAddress().equals(this.address)) {
                return true;
            }
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // 重写方法，达到深克隆
        // User要深克隆，User对象关联的Address也要克隆一份

        Address copyAddress = (Address) this.getAddress().clone();
        // 直接调用上层拷贝，那么系统会将原来的address地址赋给克隆的
        // 也就是两个user对象里面的address引用属性都会指向同一个Address对象
        // 因此这个Address对象也要重新拷贝一下啊，然后重新赋值
        User copyUser = (User) super.clone();

        copyUser.setAddress(copyAddress);

        return copyUser;
    }

}