package com.powernode.leetcode.doudizhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: 19599
 * @Date: 2025/5/29 21:45
 * @Description:
 */
public class Player {
    private final String name;
    private final List<Card> cards = new ArrayList<>();
    private boolean isBadGuy = false;

    public boolean isBadGuy() {
        return isBadGuy;
    }

    public void setBadGuy(boolean badGuy) {
        isBadGuy = badGuy;
    }

    public Player(String name) {
        this.name = name;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void sortCards() {
        Collections.sort(cards);
    }

    public void showCards() {
        System.out.println(name + "的牌为：" + cards);
    }
}
