package 目录的检查与创建;

import java.io.File;

public class MakeDirectories {
    private static void usage(){

    }

    private static void fileData(File file){
        System.out.println("绝对路径："+file.getAbsolutePath());
        System.out.println("可读："+file.canRead());
        System.out.println("可写："+file.canWrite());
        System.out.println("文件名："+file.getName());
        System.out.println("父文件名："+file.getParent());
        System.out.println("路径："+file.getPath());
        System.out.println("长度："+file.length());
        System.out.println("最后修改："+file.lastModified());

        if(file.isFile()){
            System.out.println("这是一个文件");
        }else if (file.isDirectory()){
            System.out.println("这是一个文件夹");
        }
    }

    public static void main(String[] args) {
        File file = new File("F://Hello.java");
        fileData(file);
    }
}
