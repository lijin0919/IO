import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        CharsetDecoder decoder = charset.newDecoder();
        CharBuffer charBuffer = CharBuffer.allocate(BSIZE);
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("hello".getBytes()));
        fc.close();
        fc = new RandomAccessFile("data.txt","rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("world你好".getBytes()));
        fc.close();
        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer by = ByteBuffer.allocate(BSIZE);//分配ByteBuffer

        fc.read(by);//通知FileChannel向ByteBuffer存储字节
        by.flip();//做好让别人读取字节的准备

        decoder.decode(by,charBuffer,false);

        charBuffer.flip();
        System.out.print(charBuffer);
        while (charBuffer.hasRemaining()){

        }
    }
}
