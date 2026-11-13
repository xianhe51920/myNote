package website.fairycrane;


/**
 * 任务 1：使用 try-catch-finally 代码块处理异常
 */
class ExceptionTest {

    public static void main(String[] args) {
        try {
            int a = 10;
            int b = 0;
            System.out.println(a / b);
        } catch (ArithmeticException e) {
            System.out.println("捕获到的异常信息：" + e.getMessage());
        } finally {
            System.out.println("finally 代码块被执行了");
        }
    }
}

/**
 * 任务 2：使用异常处理机制重构代码
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println(arr[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("这是个异常，不是错误");
        }
    }
}

/**
 * 任务 3：验证 try 代码块中 return 语句的执行顺序
 */
class ReturnFinallyTest {

    public static void main(String[] args) {
        System.out.println("调用 test() 之前");
        int result = test();
        System.out.println("test() 的返回值：" + result);
        System.out.println("调用 test() 之后");
    }

    static int test() {
        try {
            System.out.println("try 代码块执行，准备 return");
            return 1;
        } finally {
            System.out.println("finally 代码块执行（在 return 之前）");
        }
    }
}
