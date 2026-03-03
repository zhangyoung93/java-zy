package com.zy.demo.feature;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * java.time
 *
 * @author zy
 */
public class LocalDateTimeDemo {

    public static void main(String[] args) {
        //当前日期时间
        LocalDateTime localDateTime = LocalDateTime.now();

        //带时区的当前日期时间
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));

        //当前时间戳
        Instant instant = Instant.now();

        //日期间隔
        LocalDate startDate = LocalDate.of(2025, 1, 1);
        LocalDate endDate = LocalDate.of(2026, 1, 1);
        Period period = Period.between(startDate, endDate);

        //时间间隔
        LocalDateTime startDateTime = LocalDateTime.of(2025, 1, 1, 1, 30, 50);
        LocalDateTime endDateTime = LocalDateTime.of(2025, 1, 1, 2, 32, 53);
        Duration duration = Duration.between(startDateTime, endDateTime);

        //日期时间格式化
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        //日期时间=====>字符串
        String localDateTimeStr = dateTimeFormatter.format(localDateTime);
        //字符串=====>日期时间
        LocalDateTime myDateTime = LocalDateTime.parse("2020-02-20 00:11:22", dateTimeFormatter);
    }
}
