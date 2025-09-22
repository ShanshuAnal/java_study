package com.powernode.leetcode.doudizhu;

import java.util.*;

/**
 * @Author: 19599
 * @Date: 2025/5/29 21:48
 * @Description:
 */
public class DouDIZhu2 {
    // 设置每张牌的优先级
    private static final Map<String, Integer> CARD_VALUE_MAP = new HashMap<>();

    static {
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2", "小王", "大王"};
        for (int i = 0; i < numbers.length; i++) {
            CARD_VALUE_MAP.put(numbers[i], i + 1);
        }
    }

    public static void main(String[] args) {
        // 1. 创建牌库
        List<Card> cards = buildCards();

        // 2. 打乱牌库
        Collections.shuffle(cards);

        // 3. 创建玩家
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Player player3 = new Player("player3");
        List<Card> extra = new ArrayList<>();

        // 4. 发牌
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            if (i >= 51) {
                extra.add(card);
            } else {
                switch (i % 3) {
                    case 0 -> player1.addCard(card);
                    case 1 -> player2.addCard(card);
                    case 2 -> player3.addCard(card);
                }
            }
        }

        // 5. 用户洗牌，展示牌
        player1.sortCards();player1.showCards();
        player2.sortCards();player2.showCards();
        player3.sortCards();player3.showCards();
        Collections.sort(extra);
        System.out.println("底牌为：" + extra);
    }

    private static List<Card> buildCards() {
        List<Card> cards = new ArrayList<>();
        String[] suits = {"红心", "黑桃", "方块", "梅花"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        for (String suit : suits) {
            for (String number : numbers) {
                String display = suit + number;
                int value = CARD_VALUE_MAP.get(number);
                cards.add(new Card(display, value));
            }
        }
        cards.add(new Card("小王", CARD_VALUE_MAP.get("小王")));
        cards.add(new Card("大王", CARD_VALUE_MAP.get("大王")));

        return cards;
    }
}