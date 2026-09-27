package anno;
/*
自定义注解

public @interface 注解名称 {
    public 属性类型 属性名() default 默认值;
}

-----------

属性类型：
    基本数据类型
    String
    Class
    注解
    枚举
    以上类型的一维数组
 */
public @interface MyAnno1 {
    int show1() default 1;
    int[] show2();
    int show3() default 1;
}
