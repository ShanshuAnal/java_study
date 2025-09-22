package com.powernode.leetcode.doudizhu;

/**
 * @Author: 19599
 * @Date: 2025/5/29 21:35
 * @Description:
 */
public class Card implements Comparable<Card> {
    private final String display;
    private final int value;

    public Card(String display, int value) {
        this.display = display;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getDisplay() {
        return display;
    }

    @Override
    public String toString() {
        return display;
    }

    @Override
    public int compareTo(Card o) {
        return Integer.compare(this.value, o.value);
    }
}
