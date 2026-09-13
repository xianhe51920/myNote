package TreesetDemo1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetDemo1 {
    /**
     * 创建一个Student类，定义比较规则，然后打印输出
     * @param args 没啥用
     */
    public static void main(String[] args) {
        TreeSet<Student> stu = new TreeSet<>();
        stu.add(new Student("fairy",18));
        stu.add(new Student("crane",19));
        stu.add(new Student("qingxiao",36));
        stu.add(new Student("jingran",25));
        stu.add(new Student("suoming",16));
        stu.add(new Student("aimisi",50));
        //打印输出
        System.out.println(stu);
        //迭代器遍历
        System.out.println("迭代器");
        Iterator<Student> tsit = stu.iterator();
        while(tsit.hasNext()){
            System.out.println(tsit.next());
        }
        System.out.println("增强for");
        //增强for遍历
        for(Student s : stu){
            System.out.println(s);
        }

        //forEach遍历
        System.out.println("forEach");
        stu.forEach(System.out::println);

        /*
        如果比较对象是字符串对象，是不能重写方法的，这时候就要用到比较器排序
         */
        TreeSet<String> strList = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        strList.add("123");
        strList.add("jfies");
        strList.add("3984");
        strList.add("1");
        strList.add("asdffdga");
        strList.add("aa");
    }
}


class Student implements Comparable<Student>{
    private String name;
    private int age;
    Student(){};

    /**
     * 按照年龄升序比较,自然排序
     * @param o the object to be compared.
     * @return 负数往左，正数往右
     */
    @Override
    public int compareTo(Student o) {
        // 通过神秘的方式保留相同的姓名年龄
        int ageRule = this.age - o.age;
        int nameRule = ageRule == 0 ? this.name.compareTo(o.name) : ageRule;
        return nameRule == 0 ? -1 : nameRule;
    }

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}