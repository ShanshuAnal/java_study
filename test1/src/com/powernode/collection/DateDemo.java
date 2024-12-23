package com.powernode.collection;

import java.util.Objects;

/**
 * @Author: RG
 * @Package: com.powernode.collection
 * @name: DateDemo
 * @Date: 2024/10/16 20:29
 */
public class DateDemo {
    int year;
    int month;
    int day;

    public void run() {
        System.out.println("time flies...");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DateDemo dateDemo = (DateDemo) o;
        return year == dateDemo.year && month == dateDemo.month && day == dateDemo.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public DateDemo(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public DateDemo() {
    }
}
