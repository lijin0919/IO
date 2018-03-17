package 目录列表器;

import java.io.File;

public class DirList {

    public static void main(String[] args) {
        File path = new File("f://");//表示当前目录。
        String[] list;
        list = path.list();
        for (String dir:list
             ) {
            System.out.println(dir);
        }
    }
}
