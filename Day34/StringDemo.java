package Day34;

import org.junit.Test;


/**
 * @ClassName: StringDemo
 * @Description: 将一个字符串进行反转，将字符串中指定部分进行反转。比如"abcdefg"反转为"abfedcg"
 * @Author: TianXing.Xue
 * @Date: 2021/7/30 10:32
 * @Version:
 **/
public class StringDemo {
    //方式一：转换为char[]
    public String reverse(String str, int start, int end) {
        if (str != null && str.length() != 0) {
            char[] arr = str.toCharArray();

            for (int i = start, j = end; i <= j; i++, j--) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            return new String(arr);
        } else {
            return null;
        }
    }

    //方式二
    public String reverse1(String str, int start, int end) {
        //第一部分
        String reverseStr = str.substring(0, start);
        //第二部分
        for (int i = end; i >= start; i--) {
            reverseStr += str.charAt(i);
        }
        //第三部分
        reverseStr += str.substring(end + 1, str.length());  //左闭右开
        return reverseStr;
    }

    //方式三
    public String reverse2(String str, int start, int end) {
        StringBuilder builder = new StringBuilder(str.length());
        //第一部分
        builder.append(str.substring(0, start));
        //第二部分
        for (int i = end; i >= start; i--) {
            builder.append(str.charAt(i));
        }
        //第三部分
        builder.append(str.substring(end + 1));
        return builder.toString();

    }

    @Test
    public void testReverse() {
        String s1 = reverse("abcdefg", 1, 3);
        String s2 = reverse1("abcdefg", 1, 3);
        String s3 = reverse2("abcdefg", 1, 3);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
