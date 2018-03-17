package 缓冲输入文件;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Exe1 {

    public static List<String> read(String fileName) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        String s;

        List<String> list = new LinkedList<>();

        while ((s = in.readLine()) != null){

            list.add(s);
        }
        in.close();
        return list;
    }

    public static void main(String[] args) throws IOException {
        List<String> list = read("la.txt");

        ListIterator<String> it = list.listIterator(list.size());//指定游标所在位置
        while (it.hasPrevious()){
            System.out.println(it.previous());
        }
    }
}
