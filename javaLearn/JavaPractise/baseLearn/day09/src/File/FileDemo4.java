package File;

import java.io.File;

public class FileDemo4 {
    /*
    file类常用方法：
    lenth 返回文件大小（字节数量）
    getAbsolutPath 返回文件的绝对路径
    getPath 返回定义文件时使用的路径
    getName 返回文件的名称，带后缀
    lastModified 返回最后修改时间(时间毫秒值)
     */
    public static void main(String[] args) {
        File file = new File("E:\\下载\\图片归档\\韵律源点\\1.jpg");
        System.out.println(file.length());

        System.out.println(file.getAbsolutePath());

        System.out.println(file.getPath());

        System.out.println(file.getName());

        System.out.println(new java.util.Date(file.lastModified()));
    }
}
