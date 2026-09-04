package arraylisttest;

import java.util.ArrayList;
import java.util.Scanner;

public class altest2 {
    /*需求：创建一个存储学生对象的集合，存储 3 个学生对象，使用程序实现在控制台遍历该集合
            学生的姓名和年龄来自于键盘录入*/
    public static void main(String[] args) {
        ArrayList<Student> stuList = new ArrayList<>();
        for(int i = 1;i<=3;i++){
            System.out.println("第" + i + "次输入");
            addstudent(stuList);
        }

        for(Student s : stuList){
            System.out.println(s);
        }
    }

    private static void addstudent(ArrayList<Student> stuList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入姓名：");
        String name = sc.next();
        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        Student stu = new Student(name,age);
        stuList.add(stu);
    }
}


