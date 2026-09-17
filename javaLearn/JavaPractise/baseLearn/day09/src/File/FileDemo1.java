package File;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
    public static void main(String[] args) {
        File file = new File("E:\\下载\\图片归档\\韵律源点\\1.jpg");
        System.out.println(file.exists());

        File file1 = new File("E:\\下载\\图片归档\\", "韵律源点\\1.jpg");
        System.out.println(file1.exists());

        File file2 = new File("E:\\下载\\图片归档");
        File file3 = new File(file2, "韵律源点\\1.jpg");
        System.out.println(file3.exists());

        File file4 = new File("E:\\下载\\图片归档\\韵律源点\\2.jpg");
        try {
            file4.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static class FileDemo2 {
    }
}
