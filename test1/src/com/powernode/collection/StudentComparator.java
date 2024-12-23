package com.powernode.collection;

import java.util.Comparator;

/**
 * @Author: RG
 * @Package: com.powernode.collection
 * @name: StudentComparator
 * @Date: 2024/11/13 18:08
 *
 * 一个单独的比较器，在这个比较其中编写Student的比较规则
 */
public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
//        按名字排序
//        return o1.getName().compareTo(o2.getName());

//        按年龄排序
        return o1.getAge() - o2.getAge();
    }
}

