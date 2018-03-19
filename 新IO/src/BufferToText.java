import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
    /**
     * 转换数据
     */
    private static final int BSIZ = 1024;

    public static void main(String[] args) throws IOException {
        FileChannel
                out = new FileOutputStream("data2.txt").getChannel(),
                in = new FileInputStream("data2.txt").getChannel();
        out.write(ByteBuffer.wrap("hello你好".getBytes()));
        out.close();
        ByteBuffer buffer = ByteBuffer.allocate(BSIZ);
        in.read(buffer);
        buffer.flip();
        System.out.println(buffer.asCharBuffer());
        buffer.rewind();//返回数据最开始部分
        String encoding = System.getProperty("file.encoding");//字符集名称
        System.out.println(encoding);
        System.out.println(Charset.forName(encoding).decode(buffer));
    }
    /**
     * 练习
     * 创建并测试一个方法，使其可以打印CharBuffer中的内容，直到字符不能再打印
     */
}
