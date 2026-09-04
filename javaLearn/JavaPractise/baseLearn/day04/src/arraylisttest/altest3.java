package arraylisttest;

import java.util.ArrayList;

public class altest3 {
    /*需求：定义一个方法，方法接收一个集合对象（泛型为 `Student`），
    方法内部将年龄低于 18 的学生对象找出，并存入新集合对象，方法返回新集合*/
    public static void main(String[] args) {
        ArrayList<Student> stulist = new ArrayList<>();
        stulist.add(new Student("fairy",18));
        stulist.add(new Student("crane",19));
        stulist.add(new Student("mio",16));
        stulist.add(new Student("alice",11));
        ArrayList<Student> stu2list = selectAge(stulist);
        for(Student s : stu2list){
            System.out.println(s);
        }
    }

    private static ArrayList<Student> selectAge(ArrayList<Student> stulist) {
        ArrayList<Student> stulist2 = new ArrayList<>();
        for(Student s : stulist){
            if(s.age < 18){
                stulist2.add(s);
            }
        }
        return stulist2;
    }
}
