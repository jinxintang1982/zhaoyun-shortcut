import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class TestCharSet {

    @Test
    public void testByte() throws UnsupportedEncodingException {
        byte[] bytes = {72, 101, 108, 108, 111}; // "Hello"的字节数组
        String str = new String(bytes, "UTF-8"); // 使用UTF-8字符集解码字节数组
        System.out.println(str); // 输出: Hello
    }
}
