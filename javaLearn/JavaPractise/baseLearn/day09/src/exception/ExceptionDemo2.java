package exception;

public class ExceptionDemo2 {
    /**
     * 抛出异常
     * throw：在方法内部主动抛出一个异常对象
     * throws：在方法上声明该方法可能抛出的异常，交给调用者处理
     */
    public static void main(String[] args) {
        // throw 抛出运行时异常：调用者可以不处理，这里演示处理
        try {
            setAge(-1);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        // throws 声明的编译时异常：调用者必须处理
        try {
            setScore(150);
        } catch (ScoreException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * throw：参数校验不通过时主动抛出运行时异常，方法上不需要声明
     *
     * @param age 年龄
     */
    public static void setAge(int age) throws RuntimeException {
        if (age < 0 || age > 150) {
            // 抛出异常后，方法中后续代码不再执行
            throw new RuntimeException("年龄不合法：" + age);
        }
        System.out.println("年龄设置为：" + age);
    }

    /**
     * throws：声明该方法可能抛出的编译时异常，由调用者负责处理
     *
     * @param score 成绩
     * @throws ScoreException 成绩不合法时抛出
     */
    public static void setScore(int score) throws ScoreException {
        if (score < 0 || score > 100) {
            throw new ScoreException("成绩不合法：" + score);
        }
        System.out.println("成绩设置为：" + score);
    }
}

/**
 * 自定义异常：继承 Exception 属于编译时异常，抛出后必须处理
 * 若继承 RuntimeException 则为运行时异常，可以不处理
 */
class ScoreException extends Exception {
    public ScoreException(String message) {
        super(message);
    }
}
