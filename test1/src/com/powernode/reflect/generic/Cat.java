package com.powernode.reflect.generic;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * @Author: RG
 * @Package: com.powernode.reflect.generic
 * @name: Cat
 * @Date: 2024/12/1 14:35
 */
public class Cat extends Animal<String, Integer, Double>
        implements Eatable<String, Double>, Comparable<Cat> {

    private HashMap<String, Integer> map;

    private int num;

    private double no;

    public Cat(HashMap<String, Integer> map, Set<Double> set) {
        this.map = map;
    }

    @Override
    public int compareTo(Cat o) {
        return 0;
    }

    public HashMap<String, Integer> fun(HashMap<String, Integer> map, int[] a) {
        return this.map;
    }

    private List<String> fun1(Set<Cat> set) {
        return null;
    }
}
