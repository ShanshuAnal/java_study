package com.powernode;

import org.junit.platform.commons.util.StringUtils;

import java.util.Date;

public class test1 {
    public int i;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "test1{" +
                "i=" + i +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof test1 test11) {
            return test11.getI() == i;
        }
        return false;
    }

    public static void main(String[] args) {
        Date d4 = new Date();
        System.out.println(d4);
        // 这里就是空指针异常
        System.out.println(d4.toString());

        
    }
}
