package anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
元注解：自定义注解的注解
@Target 指定了注解在哪里使用
    TYPE 类，接口
    TIELD 成员变量
    METHLD 成员方法
    PARAMETER 方法参数
    CONSTRUCTOR 构造方法
    LOCAL_VARIABLE 局部变量
@Retention 可以理解为保留时间（生命周期）
    SOURCE 注解只作用在源码阶段，生成的字节码文件中不存在
    CLASS 注解作用在源码阶段，字节码文件阶段，运行阶段不存在，默认值
    RUNTIME 注解作用在源码阶段，字节码文件阶段，运行阶段
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test  {
}
