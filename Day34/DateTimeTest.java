package Day34;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: DateTimeTest
 * @Description: jdk 8之前的日期时间的API测试
 * @Author: TianXing.Xue
 * @Date: 2021/7/30 13:45
 * @Version: 1.0
 *
 * 1.System类中currentTimeMillis();
 * 2.java.util.Date 和子类java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calender
 **/

public class DateTimeTest {
    /*
    SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析

    1.两个操作：
    1.1格式化：日期 --> 字符串
    1.2解析： 格式化的逆过程，字符串 --> 日期

    2.SimpleDateFormat实例化

     */

    @Test
    public void testSimpleDateFormat() throws ParseException {
        //实例化SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 --> 字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：格式化的过程，字符串 --> 日期
        String str = "1221/7/30 下午2:13";
        Date parse = sdf.parse(str);
        System.out.println(parse);

        //************按照指定的方式格式化和解析：调用带参的构造器****************
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format1 = sdf1.format(date);
        System.out.println(format1);
        //解析：要求字符串必须是符合SimpleDateFormat识别的格式(通过构造器参数体现)
        //否则就会抛出异常
        Date parse1 = sdf1.parse("2020-02-18 11:48:12");
        System.out.println(parse1);
    }

    /*
    练习一：字符串"2020-09-08"转换为java.sql.Date

     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(birth);
        java.sql.Date date = new java.sql.Date(parse.getTime());
        System.out.println(date);
    }

    /*
    Calender日历类的使用

     */
    @Test
    public void testCalender() {
        //1.实例化
        //方式一：创建其子类(GregorianCalender)对象
        //方式二：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass());

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_MONTH, 22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime()：日历类 --> Date()
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime()：Date --> 日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }
}
