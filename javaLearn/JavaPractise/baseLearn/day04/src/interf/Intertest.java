package interf;

public class Intertest {
    public static void main(String[] args) {
        Imple im = new Imple();
        use(im);
    }

    private static void use(Inter i){
        i.show();
    }
}



interface Inter {
    void show();
}

class Imple implements Inter{
    @Override
    public void show() {
        System.out.println("打印show方法");
    }
}