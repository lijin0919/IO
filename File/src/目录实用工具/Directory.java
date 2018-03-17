package 目录实用工具;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class Directory {

    public static File[] local(File dir, final String regex){
        return dir.listFiles(new FilenameFilter(){
            public boolean accept(File dir,String name){
                Pattern pattern=Pattern.compile(regex);
                return pattern.matcher(new File(name).getName()).matches();
            }
        });
    }
    public static File[] local(String path,String regex){
        return local(new File(path),regex);
    }
    public static class TreeInfo{
        public List<File> files=new ArrayList<File>();
        public List<File> dirs=new ArrayList<File>();
        public Iterator<File> iterator(){
            return files.iterator();
        }
        public void addAll(TreeInfo other){
            dirs.addAll(other.dirs);
            files.addAll(other.files);
        }
        public String toString(){
            StringBuilder sb=new StringBuilder();
            sb.append("dirs:");
            sb.append(dirs);
            sb.append("\nfiles");
            sb.append(files);
            return sb.toString();
        }
        public static TreeInfo walk(File start,String regex){
            return recurseDirs(start,regex);
        }
        public static TreeInfo walk(String start,String regex){
            return walk(new File(start),regex);
        }
        public static TreeInfo walk(String start){
            return walk(new File(start));
        }
        public static TreeInfo walk(File start){
            return walk(start,".*");
        }
        static TreeInfo recurseDirs(File startDir,String regex){
            TreeInfo result=new TreeInfo();
            for(File item:startDir.listFiles()){
                if(item.isDirectory()){
                    result.dirs.add(item);
                    result.addAll(recurseDirs(item,regex));
                }else{
                    if(item.getName().matches(regex)){
                        result.files.add(item);
                    }
                }
            }
            return result;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        if(args.length==0)
            System.out.println(TreeInfo.walk("."));
        else
            for(String arg:args){
                System.out.println(TreeInfo.walk(arg));
            }
    }

}
