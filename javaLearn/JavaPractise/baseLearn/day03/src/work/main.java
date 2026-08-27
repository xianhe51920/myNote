package work;

public class main {
    public static void main(String[] args) {
        Coder c1 = new Coder("fairy",18,18000);
        Manager m1 = new Manager("crane",23,49999,199);
        System.out.println(c1.getName()+"---"+c1.getAge()+"---"+c1.getSalary());
        System.out.println(m1.getName()+"---"+m1.getAge()+"---"+m1.getSalary()+"---"+m1.getBonus());
        c1.work(); 
        m1.work();
    }
}
