package Day34;

import org.junit.Test;

/**
 * @ClassName: StringDemo2
 * @Description: 获取两个字符串中最大相同子串
 * @Author: TianXing.Xue
 * @Date: 2021/7/30 12:47
 * @Version: 2.0
 **/

//前提：只有一个最大相同子串
public class StringDemo2 {
    public String maxString(String str1, String str2) {
        if (str1 != null && str2 != null) {
            String maxString = (str1.length() >= str2.length()) ? str1 : str2;
            String minString = (str1.length() < str2.length()) ? str1 : str2;
            int length = minString.length();
            for (int i = 0; i < length; i++) {
                for (int x = 0, y = length - i; y <= length; x++, y++) {
                    String substring = minString.substring(x, y);
                    if (maxString.contains(substring)) {
                        return substring;
                    }
                }
            }
            return null;
        }
        return null;
    }

    @Test
    public void test() {
        String str1 = "jfdjfdsfsdkshcbrytnv";
        String str2 = "ijdffsdkshaiornnv";
        String s = maxString(str1, str2);
        System.out.println(s);
    }
}
