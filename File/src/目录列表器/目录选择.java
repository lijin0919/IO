package 目录列表器;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class 目录选择 {
    private JList list1;
    private JButton button1;
    private JPanel p1;
    private JButton button2;

    public 目录选择() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File path = new File(".");//表示当前目录。
                String[] list;
                list = path.list();
                list1.setListData(list);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File path = new File("f://");//表示当前目录。
                String[] list;
                list = path.list(new DirFilter(".java"));
                list1.setListData(list);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("目录选择");
        frame.setContentPane(new 目录选择().p1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    class DirFilter implements FilenameFilter{

        private String type;

        public DirFilter(String type) {
            this.type = type;
        }

        @Override
        public boolean accept(File dir, String name) { //dir表示文件的当前目录，name表示文件名；
            return name.endsWith(type);
        }


    }
}
