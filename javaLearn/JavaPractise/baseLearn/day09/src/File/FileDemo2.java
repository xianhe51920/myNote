package File;

import java.io.File;

public class FileDemo2 {
    public static void main(String[] args) {
        File file = new File("../baseLearn"); //相对当前项目的路径
        System.out.println(file.exists());
    }
}
