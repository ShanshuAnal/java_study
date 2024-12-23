package com.powernode;

import org.junit.jupiter.api.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: RG
 * @Package: com.powernode
 * @name: TimeTest
 * @Date: 2024/10/15 0:50
 */
public class TimeTest {

    @Test
    public void testDate() {
        String s = "123";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);


        // 1970.1.1 00:00:00 UTC(全球标准时间) 到当前时间的总毫秒数
        // CST是东八区北京时间
        long l = System.currentTimeMillis();
        System.out.println(l);

        Date date = new Date(1000);
        System.out.println(date);

        Date date1 = new Date(System.currentTimeMillis());
        System.out.println(date1);

        Date date2 = new Date(System.currentTimeMillis() - 1000 * 60 * 10);
        System.out.println(date2);
    }

    // 日期格式化
    @Test
    public void testDateFormat() throws ParseException {
        // DateFormat 是 SimpleDateFormat 的父类
        DateFormat df;
        SimpleDateFormat sdf;

        // Date -> String
        Date date = new Date();
        System.out.println(date);
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        String format = sdf.format(date);
        System.out.println(format);

        // String -> Date
        String strDate = "2024-10-15 01:08:30 474";
        Date date1 = sdf.parse(strDate);
        System.out.println(date1);
    }


    @Test
    public void testCalendar() {
        // 单例模式
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);

        System.out.println(instance.get(Calendar.YEAR));
        System.out.println(instance.get(Calendar.MONTH));

        System.out.println(instance.get(Calendar.DAY_OF_MONTH));
        System.out.println(instance.get(Calendar.DAY_OF_YEAR));
        System.out.println(instance.get(Calendar.DAY_OF_WEEK));

        System.out.println(instance.get(Calendar.HOUR));
        System.out.println(instance.get(Calendar.HOUR_OF_DAY));

        System.out.println(instance.get(Calendar.MINUTE));
    }

    @Test
    public void testCalender01() throws ParseException {
        // 系统当前时间日历
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR, 2008);
        System.out.println(instance.get(Calendar.YEAR));

        // 获取日历具体时间
        // 改日历
        instance.set(2008, Calendar.AUGUST, 8, 8, 8, 8);
        System.out.println(instance.get(instance.MONTH));

        instance.add(instance.YEAR, 1);
        System.out.println(instance.get(instance.YEAR));

        // 获取某个特定时间
        // 获取一个2008年5月12日15点20分20秒的Date
        String strDate = "2002-05-12 15:20:20";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(strDate);
        instance.setTime(date);
        System.out.println(instance.get(Calendar.HOUR_OF_DAY));
        System.out.println(instance.get(Calendar.MINUTE));
        System.out.println(simpleDateFormat.format(instance.getTime()));
    }

    // 以上在多线程并发的环境会出现错误

    /**
     * LocalDate        日期
     * LocalTime        时间
     * LocalDateTime    日期时间
     */
    @Test
    public void testJava8Api() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalDateTime.of(2002, 9, 14, 2, 2, 2, 22);
        System.out.println(localDateTime1);
        LocalDateTime localDateTime2 = localDateTime1.minusYears(1).minusMonths(1).minusDays(1).minusHours(1).minusMinutes(1).minusSeconds(1).minusNanos(10);
        System.out.println(localDateTime2);

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getDayOfYear());
        System.out.println(localDateTime.getDayOfWeek().getValue());
        System.out.println(localDateTime.getDayOfMonth());
    }

    /**
     * 链式调用
     */
    public TimeTest m1() {
        System.out.println("m1");
        return this;
    }

    public TimeTest m2() {
        System.out.println("m2");
        return this;
    }

    public TimeTest m3() {
        System.out.println("m3");
        return this;
    }

    @Test
    public void test1() {
        TimeTest timeTest = new TimeTest();
        timeTest.m1().m2().m3();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("123").append("456");
    }


    /**
     * 时间戳
     */
    @Test
    public void testInstant() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        Instant now = Instant.now();
        System.out.println(now);

        long epochMilli = now.toEpochMilli();
        System.out.println(epochMilli);
    }

    /**
     * 时间间隔
     */
    @Test
    public void testDuration() {
        LocalDateTime localDateTime1 = LocalDateTime.of(2008, 2, 2, 2, 2, 2);
        LocalDateTime localDateTime2 = LocalDateTime.of(2009, 3, 3, 3, 3, 3);
        Duration between = Duration.between(localDateTime1, localDateTime2);
        System.out.println(between.toHours() + "s");
        System.out.println(between.toDays() + "d");
    }

    /**
     * 日期间隔
     */
    @Test
    public void testPeriod() {
        LocalDate localDate = LocalDate.of(2007, 7, 7);
        LocalDate localDate1 = LocalDate.of(2008, 8, 8);
        Period between = Period.between(localDate, localDate1);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
    }

    /**
     * 时间矫正器
     */
    @Test
    public void testTemporalAdjusters() {
        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDateTime localDateTime1 = localDateTime.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(localDateTime1);

        LocalDateTime localDateTime2 = localDateTime1.with(TemporalAdjusters.lastDayOfYear());
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime2.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(localDateTime3);
        System.out.println(localDateTime3.getMonth());
        System.out.println(localDateTime3);
    }

    /**
     * 日期格式化
     */
    @Test
    public void testDateTimeFormat() {
        // LocalDateTime -> String
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(localDateTime);
        System.out.println(format);

        // String -> LocalDateTime
        LocalDateTime parse = LocalDateTime.parse(format, dateTimeFormatter);
        System.out.println(parse);

    }
}
