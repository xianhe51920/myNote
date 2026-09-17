package File;

import java.io.File;
import java.util.Scanner;

public class FileTest1 {
    /*
    需求：键盘录入一个文件夹路径，如果输入错误就给出提示，并继续录入，直到正确为止
     */
    public static void main(String[] args) {
        File file;
        while(true){
            File f2 = getFile();
            if(f2.exists() && f2.isDirectory()){
                file = f2;
                System.out.println("录入成功");
                break;
            }else{
                System.out.println("录入失败");
            }
        }
    }

    public static File getFile(){
        Scanner sc = new Scanner(System.in);
        String path = sc.next();
        return new File(path);
    }
}
