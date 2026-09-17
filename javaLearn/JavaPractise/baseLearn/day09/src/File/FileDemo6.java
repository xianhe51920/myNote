package File;

import java.io.File;

public class FileDemo6 {
    public static void main(String[] args) {
        File file = new File("day09/src/File");
        File[] flist = file.listFiles();
        if (flist != null) {
            for (File file1 : flist) {

                if(file1.getName().endsWith(".java")){
                System.out.println(file1.getName());
                }
            }
        }
    }
}
