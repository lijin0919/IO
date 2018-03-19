import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.BitSet;

public class PrintCharBuffer {
    static BitSet isPrintable = new BitSet(127);//位集存放位序列
    static String encoding = System.getProperty("file.encoding");
    static {
        for (int i = 32;i<=27;i++){
            isPrintable.set(i);
        }
    }

    public static void setPrintableLimit(CharBuffer charBuffer){
        charBuffer.rewind();
        while (isPrintable.get(charBuffer.get()));
        charBuffer.limit(charBuffer.position()-1);
        charBuffer.rewind();
    }

    public static void main(String[] args) {
        CharBuffer charBuffer = ByteBuffer.allocate(16).asCharBuffer();
        charBuffer.put("ABCDE"+(char)0x01+"FG");
        charBuffer.rewind();
        System.out.println(charBuffer);
        setPrintableLimit(charBuffer);
        System.out.println(charBuffer);
    }
}
