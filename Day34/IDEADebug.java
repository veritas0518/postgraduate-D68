package Day34;

import org.junit.Test;

/**
 * @ClassName: IDEADebug
 * @Description:
 * @Author: TianXing.Xue
 * @Date: 2021/7/30 13:27
 * @Version:
 **/
public class IDEADebug {
    @Test
    public void testStringBuffer() {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());
        System.out.println(sb);
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}
