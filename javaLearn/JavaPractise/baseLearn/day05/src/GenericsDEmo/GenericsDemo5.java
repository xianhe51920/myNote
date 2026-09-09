package GenericsDEmo;

import java.util.ArrayList;

public class GenericsDemo5 {
    /*
        泛型通配符

                ? : 任意类型

                ? extends E : 可以传入的是E, 或者是E的子类

                ? super E : 可以传入的是E, 或者是E的父类
     */
    public static void main(String[] args) {

        ArrayList<Coder> list1 = new ArrayList<>();
        list1.add(new Coder());

        ArrayList<Manager> list2 = new ArrayList<>();
        list2.add(new Manager());

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("abc");

        method(list1);
        method(list2);

    }

    public static void method(ArrayList< ? extends Employee> list) {
        for (Employee e : list) {
            e.work();
        }
    }

}

abstract class Employee {
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Employee{name = " + name + ", salary = " + salary + "}";
    }
}

class Coder extends Employee {
    @Override
    public void work() {
        System.out.println("程序员写代码...");
    }
}

class Manager extends Employee {
    @Override
    public void work() {
        System.out.println("项目经理分配任务...");
    }
}
