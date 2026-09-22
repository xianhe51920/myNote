package Thread;

import java.util.concurrent.Callable;

// 结果是什么类型泛型就写什么类型
class MyCall implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "我喜欢你，和我在一起吧";
    }
}
