package com.powernode.leetcode.doudizhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: 19599
 * @Date: 2025/5/29 21:36
 * @Description:
 */
public class DouDiZhuOriginal {
    public static void main(String[] args) {
        // 1. 准备牌
        List<String> cards = new ArrayList<>();
        String[] suits = {"红心", "黑桃", "方块", "梅花"};
        String[] numbers = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        for (String suit : suits) {
            for (String number : numbers) {
                cards.add(suit + number);
            }
        }
        cards.add("大王");
        cards.add("小王");

        // 2. 洗牌
        Collections.shuffle(cards);

        // 3. 发牌
        List<String> player1 = new ArrayList<>();
        List<String> player2 = new ArrayList<>();
        List<String> player3 = new ArrayList<>();
        List<String> extra = new ArrayList<>();


        for (int i = 0; i < cards.size(); i++) {
            String card = cards.get(i);
            if (i >= 51) {
                extra.add(card);
            } else if (i % 3 == 0) {
                player1.add(card);
            } else if (i % 3 == 2) {
                player2.add(card);
            } else {
                player3.add(card);
            }
        }

        System.out.println("player1的牌为：" + player1);
        System.out.println("player2的牌为：" + player2);
        System.out.println("player3的牌为：" + player3);
        System.out.println("底牌为：" + extra);
    }
}
