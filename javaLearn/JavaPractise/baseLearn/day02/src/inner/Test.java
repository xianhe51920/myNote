package inner;

public class Test {
    public static void main(String[] args) {
        Outer.Inner in = new Outer().new Inner();
        in.show();
    }
}

class Outer {
    int num = 150;
    class Inner{
        int num = 110;
        public void show(){
            int num = 78;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(Outer.this.num);
        }
    }
}
