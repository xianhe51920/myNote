package File;

import java.io.File;

public class FileDemo3 {
    /**
     * File类的判断方法
     */
    public static void main(String[] args) {
        File file = new File("E:/myNote");
        // 是否是文件夹
        System.out.println(file.isDirectory());
        File file2 = new File("E:\\下载\\图片归档\\韵律源点\\1.jpg");
        // 是否是文件
        System.out.println(file2.isFile());
        // 是否存在
        System.out.println(file.exists());
    }
}
