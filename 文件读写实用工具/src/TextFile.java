import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String>{

    public static String read(String fileName){

        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
            try {
                String s;
                while ((s = in.readLine())!=null){
                    sb.append(s);
                    sb.append("\n");
                }
            }catch (Exception e){

            }finally {
                in.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static void write(String fileName,String text){
        try{
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try{
                out.print(text);
            }finally {
                out.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public TextFile(String fileName,String splitter){
        super(Arrays.asList(read(fileName).split(splitter)));
        if(get(0).equals("")){
            remove(0);
        }
    }

    public TextFile(String fileName){
        this(fileName,"\n");
    }

    public void write(String fileName){
        try{
            PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
            try{
                for (String item:this){
                    out.print(item);
                }
            }finally {
                out.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String file = read("f://Hello.java");
        write("test.txt",file);
        TextFile textFile = new TextFile("test.txt");
        textFile.write("test2.txt");
        TreeSet<String> words = new TreeSet<>(new TextFile("f://Hello.java","\\W+"));//数字、字母、下划线和加号本身字符
        System.out.println(words.headSet("a"));
    }
}
