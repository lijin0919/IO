package OutPutStream;

import java.io.FileOutputStream;

public class FileOutPutStreamDemo {
    public static void main(String[] args) {
        try {
            //向文件中写入字节数组
            String font="输出流是用来写入数据的！";
            FileOutputStream fos = new FileOutputStream("FOSDemo.txt");
            fos.write(font.getBytes());
            //关闭此文件输出流并释放与此流有关的所有系统资源。此文件输出流不能再用于写入字节。 如果此流有一个与之关联的通道，则关闭该通道。
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
