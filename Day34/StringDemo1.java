package Day34;

import org.junit.Test;

/**
 * @ClassName: StringDemo1
 * @Description: 获取一个字符串在另一个字符串中出现的次数，比如：获取"ab"在"aaaaaabaabababbbbb"中出现的次数
 * @Author: TianXing.Xue
 * @Date: 2021/7/30 11:40
 * @Version:
 **/
public class StringDemo1 {
    public int getCount(String son, String mom) {
        int count = 0;
        int sonLength = son.length();
        int monLength = mom.length();
        int index = 0;
        if (sonLength <= monLength) {
            //方式一
            //            while ((index=mom.indexOf(son))!=-1){
//                count++;
//                mom = mom.substring(index+son.length());
//            }

            //方式二
            while ((index = mom.indexOf(son, index)) != -1) {
                count++;
                index += sonLength;
            }
            return count;
        } else {
            return -1;
        }
    }

    @Test
    public void testGetCount() {
        String mom = "fhoahabsoofabfdofhabaa";
        String son = "ab";
        int count = getCount(son, mom);
        System.out.println(count);
    }
}
