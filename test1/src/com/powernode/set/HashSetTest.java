package com.powernode.set;

import com.powernode.collection.Student;
import com.powernode.map.UserDemo;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: RG
 * @Package: com.powernode.set
 * @name: HashSetTest
 * @Date: 2024/11/21 16:52
 */
public class HashSetTest {
    @Test
    public void test() {
        Set<String> set = new HashSet<>();

        set.add("asd");
        set.add("asd");
        set.add("asda");

        System.out.println(set);
    }

    /**
     * 关于TreeSet的排序
     * 有序，不可重复（重写 hashCode + equals）
     *
     * 1. 储存在HashSet中的实体类实现Comparable接口
     * 2. 构建比较器Comparator
     */
    @Test
    public void test1() {
        HashSet<UserDemo> set = new HashSet<>();
        UserDemo user = new UserDemo("zhangsan", 12);
        set.add(user);
        set.add(new UserDemo("lisi", 123));
        System.out.println(set);

        user.setName("wuwang");

        // 没删除
        // 因为user名字改成wuwang后，对象的哈希值已经和哈希表节点中的哈希值不一样了
        // 因为哈希值是根据name和age一起计算出来的
        // 所以remove(user),程序根据修改姓名后的user计算哈希值，在哈希表中找不到了，因此就删除失败了
        set.remove(user);
        System.out.println(set);

        // 添加成功了
        // 因为这个的哈希值和哈希表中那个wuwang的哈希值不一样，set判定是两个不同的UserDemo对象
        set.add(new UserDemo("wuwang", 12));
        System.out.println(set);

        // 添加成功
        // 首先根据它的属性计算出来的哈希值和第一个wuwang的哈希值一样，那应该在那条单链表上进行操作，
        // 哈希值的作用到此结束，因为判断equals跟哈希值没关系，看的是name 和 age；
        // 进一步，当程序遍历到第一个wuwang对象时，两个对象姓名不对，不是equals的，因而继续往下，最终加入
        set.add(new UserDemo("zhangsan", 12));
        System.out.println(set);
    }
}
