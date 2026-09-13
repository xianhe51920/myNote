package hashset;

import pojo.Student;

import java.util.HashSet;

public class HashSetDemo {
    /**
     * HashSet保证元素不会重复
     * @param args
     */
    public static void main(String[] args) {
        HashSet<Student> hs = new HashSet<>();
        hs.add(new Student("fairy", 18));
        hs.add(new Student("crane", 19));
        hs.add(new Student("suoming", 20));
        hs.add(new Student("ailice", 16));
        hs.forEach(student -> {
            System.out.println("姓名" + student.getName());
            System.out.println("年龄" + student.getAge());
        });
    }
}
