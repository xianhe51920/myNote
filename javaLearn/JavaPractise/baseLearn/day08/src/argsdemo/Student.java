package argsdemo;

import java.util.Objects;

public class Student implements Comparable<Student>{
    private String name;
    private int age;
    public Student(){};

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Student(String name, int age){
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

