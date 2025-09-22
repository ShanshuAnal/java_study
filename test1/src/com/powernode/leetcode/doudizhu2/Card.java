package com.powernode.leetcode.doudizhu2;

/**
 * @Author: 19599
 * @Date: 2025/6/1 15:50
 * @Description:
 */
public class Card implements Comparable<Card>{
    private String display;
    private int value;

    public Card(String display, int value) {
        this.display = display;
        this.value = value;
    }

    public String getDisplay() {
        return display;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.value, o.value);
    }

    @Override
    public String toString() {
        return display;
    }
}
