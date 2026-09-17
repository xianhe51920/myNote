package File;

import java.io.File;
import java.io.IOException;

public class FileDemo5 {
    /*
    类的创建和删除方法：
    createNewFile() 创建一个新的空的文件
    mkdir() 只能创建一级文件夹
    mkdirs() 可以创建多级文件夹

    delete() 删除由此抽象路径名表示的文件或空文件夹
     */
    public static void main(String[] args) throws IOException {
        File file = new File("day09/src/File/FileTestDir.txt");
        System.out.println(file.createNewFile());

        File file1= new File("day09/src/File/FileTestDir");
        System.out.println(file1.mkdir());

        File file2 = new File("day09/src/File/FileTest2Dir/FileTest");
        System.out.println(file2.mkdirs());

        System.out.println(file.delete());
        System.out.println(file1.delete());
        System.out.println(file2.delete());

    }
}
