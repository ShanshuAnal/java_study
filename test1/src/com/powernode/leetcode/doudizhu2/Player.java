package com.powernode.leetcode.doudizhu2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: 19599
 * @Date: 2025/6/1 15:57
 * @Description:
 */
public class Player {
    private final String name;
    private List<Card> cards = new ArrayList<>();
    private boolean isLander = false;

    public Player(String name) {
        this.name = name;
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public void receiveCards(List<Card> but) {
        cards.addAll(but);
    }

    public void sortCards() {
        Collections.sort(cards);
    }

    public void showCards() {
        System.out.println(name + "持有的牌：" + cards);
    }

    public void setLander() {
        isLander = true;
    }

    public boolean isLander() {
        return isLander;
    }
}