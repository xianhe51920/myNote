package Shape;

public abstract class Shape {
    public static void main(String[] args) {
        useEat(new Cat());
        useEat(new Dog());

    }
    private static void useEat(Animal a){
        a.eat();
    }
}
abstract class Animal{
    public abstract void eat();
}

class Cat extends Animal{
    @Override
    public void eat() {
        System.out.println("猫吃鱼");
    }
}
class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}