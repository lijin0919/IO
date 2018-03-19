import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TransferTo {
    /**
     * 将两个通道相连
     */
    public static void main(String[] args) throws IOException{
        FileChannel
                in = new FileInputStream("data.txt").getChannel(),
                out = new FileOutputStream("data_c1.txt").getChannel();
        in.transferTo(0,in.size(),out);
        out.transferFrom(in,0,in.size());

    }
}
