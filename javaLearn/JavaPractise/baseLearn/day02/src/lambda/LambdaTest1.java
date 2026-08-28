package lambda;

public class LambdaTest1 {
    public static void main(String[] args) {
        useShowHandler(() -> System.out.println("lambda方法"));
    }

    private static void useShowHandler(ShowHandler showHandler) {
        showHandler.show();
    }

}

interface ShowHandler {
    void show();
}