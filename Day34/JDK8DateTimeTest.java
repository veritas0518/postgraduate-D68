package Day34;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * @ClassName: JDK8DateTimeTest
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/7/30 23:10
 * @Version:
 **/
public class JDK8DateTimeTest {
    @Test
    public void testDate() {
        //偏移量
        Date date = new Date(2020 - 1900, 9 - 1, 8);
        System.out.println(date);
    }

    /*
    LocalDate、LocalTime、LocalDateTime的使用
    说明：
        1.LocalDateTime相较于LocalDate、LocalTime,使用频率较高
     */

    @Test
    public void test1() {
        //now():获取当前的日期、事件、日期+时间
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of():设置指定的年、月、日、时、分、秒是没有偏移量的
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 13, 23, 4);
        System.out.println(localDateTime1);

        //getXxx()
        //获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //体现不可变性
        //withXxx:设置相关的属性
        LocalDateTime localDateTime2 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.withHour(4);
        System.out.println(localDateTime3);

        //不可变性
        LocalDateTime localDateTime4 = localDateTime.plusMonths(3);
        System.out.println(localDateTime4);

        LocalDateTime localDateTime5 = localDateTime.minusDays(6);
        System.out.println(localDateTime5);
    }

    /*
    Instant的使用
    类似于 java.util.Date类
     */
    @Test
    public void test2() {
        //now()：获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //toEpochMilli():获取自1970年1月1日0时0分0秒(UTC)开始的毫秒数 --> Date类的getTime()
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数，获取Instant实例 --> Date(long millis)
        Instant instant1 = Instant.ofEpochMilli(1500475314878L);
        System.out.println(instant1);
    }

    /*
    DateTimeFormat:格式化或解析日期、时间
    类似于SimpleDateFormat

     */
    @Test
    public void test3() {
        //方式一：预定义的标准格式
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化:日期 --> 字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        //解析：字符串 --> 日期
        TemporalAccessor parse = formatter.parse("2021-07-31T16:02:22.5299274");
        System.out.println(parse);

        //方式二：
        //本地化相关的格式。
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG);
        //格式化
        String format = formatter1.format(localDateTime);
        //String format1 = formatter2.format(localDateTime);
        System.out.println(format);
        //System.out.println(format1);

        //本地化相关的格式
        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL);
        //格式化
        String str3 = formatter2.format(LocalDate.now());
        // System.out.println(str3);

        //方式三：自定义的格式。
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4);

        //解析
        TemporalAccessor accessor = formatter3.parse("2021-7-31 16:16:04");
        System.out.println(accessor);

    }
}
