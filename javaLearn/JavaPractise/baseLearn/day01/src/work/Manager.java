package work;

public class Manager extends Employee {
    private int bonus;

    /**
     * 无参构造方法
     */
    public Manager() {
    }

    /**
     * 有参构造方法
     * @param name 姓名
     * @param age 年龄
     * @param salary 薪资
     * @param bonus 奖金
     */
    public Manager(String name, int age, int salary, int bonus) {
        super(name, age, salary);
        this.bonus = bonus;
    }

    //set和get方法

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void work(){
        System.out.println("姓名为"+getName()+','+"年龄为"+getAge()+','+"工资为"+getSalary()+"奖金为"+bonus+"的项目经理正在分配任务");
    }
}
