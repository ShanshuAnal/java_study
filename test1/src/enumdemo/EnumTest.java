package enumdemo;

import org.junit.jupiter.api.Test;

import javax.swing.*;

/**
 * @Author: 19599
 * @Date: 2024/12/9 16:16
 */
public class EnumTest {
    @Test
    public void test1() {
        Season[] values = Season.values();
        for (Season season : values) {
            System.out.println(season.ordinal());
            System.out.println(season.name());
        }

        Season spring = Season.SPRING;
        System.out.println(spring);

        System.out.println(spring == Season.SPRING);

        Season season = Season.valueOf("SUMMER");
        System.out.println(season);

    }

    @Test
    public void test2() {
        Sport sport = getSport();
        switch (sport) {
            case BASKETBALL -> System.out.println(Sport.BASKETBALL.getName() + " === " + Sport.BASKETBALL.getNum());
            case TENNIS -> System.out.println(Sport.TENNIS.getName() + " === " + Sport.TENNIS.getNum());
            case FOOTBALL -> System.out.println(Sport.FOOTBALL.getName() + " === " + Sport.FOOTBALL.getNum());
            case SWIMMING -> System.out.println(Sport.SWIMMING.getName() + " === " + Sport.SWIMMING.getNum());
        }
    }

    public static Sport getSport() {
        return Sport.BASKETBALL;
    }

    @Test
    public void test3() {
        Sport[] values = Sport.values();
        for (Sport sport : values) {
            System.out.println(sport.ordinal() + "===" +sport.name());
            sport.run();
            sport.enjoy();
            System.out.println("*****************");
        }
    }
}
