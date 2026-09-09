package GenericsDEmo;

public class GenericsDemo2 {
    /**
     * 泛型接口
     * 1.实现类，实现接口的时候确定到具体的类型
     * 2.实现类实现接口，没有指定具体类型，就让接口的泛型，跟着类的泛型去匹配
     */
    public static void main(String[] args) {

    }
}

interface Inter<E> {
    void show(E e);
}

// 1.
class InterAImpal implements Inter<Integer>{
    public void show(Integer i){
        System.out.println(i);
    }
}

// 2.
class InterBImpal <E> implements Inter<E>{
    public void show(E e){
        System.out.println(e);
    }
}
