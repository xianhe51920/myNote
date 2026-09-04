package lambda;

public class LambdaTest2 {
    public static void main(String[] args) {
        useStringHandler((String msg) -> System.out.println(msg));
    }

    private static void useStringHandler(StringHandler stringHandler) {
        stringHandler.printMessage("itheima");
    }
}

@FunctionalInterface
interface StringHandler {
    void printMessage(String msg);
}
