package lambda;

import java.util.Random;

public class LambdaTest3 {
    public static void main(String[] args) {
        useRandomNumHandler(() -> {
            Random r = new Random();
            return r.nextInt(10);
        });
    }

    private static void useRandomNumHandler(RandomNumHandler randomNumHandler) {
        int result = randomNumHandler.getNumber();
        System.out.println(result);
    }
}

interface RandomNumHandler {
    int getNumber();
}
