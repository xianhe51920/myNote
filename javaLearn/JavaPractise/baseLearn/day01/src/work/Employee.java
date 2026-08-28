package work;

public class Employee {
    private String name;
    private int age;
    private int salary;

    /**
     * 空参构造方法
     */
    public Employee() {
    }

    /**
     * 带参构造方法
     * @param name 姓名
     * @param age 年龄
     * @param salary 工资
     */
    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    //get和set方法-----------------------------
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    //----------------------------------------

    public void work(){
        System.out.println("员工工作");
    }
}
