package com.powernode.leetcode.doudizhu2;

import com.powernode.leetcode.doudizhu2.Card;

import java.util.*;

/**
 * @Author: 19599
 * @Date: 2025/6/1 15:43
 * @Description:
 */
public class DouDiZhu {
    private final static Map<String, Integer> CARD_VALUE_MAP = new HashMap<>();

    static {
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "小王", "大王"};
        for (int i = 0; i < numbers.length; i++) {
            CARD_VALUE_MAP.put(numbers[i], i + 1);
        }
    }

    public static void main(String[] args) {
        // 1. 构建牌
        List<Card> cards = new ArrayList<>();
        buildCards(cards);
        Collections.shuffle(cards);

        // 2. 构建玩家
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Player player3 = new Player("player3");
        List<Card> but = new ArrayList<>();

        // 3. 发牌
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (i >= 51) {
                but.add(card);
            } else {
                switch (i % 3) {
                    case 0 -> player1.receiveCard(card);
                    case 1 -> player2.receiveCard(card);
                    case 2 -> player3.receiveCard(card);
                }
            }
        }

        // 4. 展示
        player1.sortCards();
        player1.showCards();

        player2.sortCards();
        player2.showCards();

        player2.sortCards();
        player3.showCards();

        Collections.sort(but);
        System.out.println(but);

    }

    private static void buildCards(List<Card> cards) {
        String[] suits = {"红心", "黑桃", "梅花", "方块"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (String suit : suits) {
            for (String number : numbers) {
                int val = CARD_VALUE_MAP.get(number);
                String display = suit + number;
                cards.add(new Card(display, val));
            }
        }
        cards.add(new Card("小王", CARD_VALUE_MAP.get("小王")));
        cards.add(new Card("大王", CARD_VALUE_MAP.get("大王")));
    }
}
