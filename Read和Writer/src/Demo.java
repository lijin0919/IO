import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        Writer w=new FileWriter(new File("la.txt"));

        //往里面写入内容
        BufferedWriter biw=new BufferedWriter(w);
        biw.write("hello world");
        //写入一个行分隔符。
        biw.newLine();
        biw.write("你好");

        //刷新该流的缓冲，将缓冲区的数据立刻写出来
        biw.flush();

        Reader r=new FileReader("la.txt");

        //FileReader一次只读取一个字节，BufferedReader将读取的内容放到内存的缓冲区里面，等缓冲区满了在读取
        BufferedReader bir=new BufferedReader(r);

        String str="";

        while((str=bir.readLine())!=null)
        {
            System.out.println(str);

        }

        biw.close();
        bir.close();
    }
}
