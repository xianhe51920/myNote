package API;

import java.util.Date;

public class DateDemo {
    /*
    Date类

    构造方法：
    Date() 创建一个Date对象
    Date(long time) 把时间毫秒值转换成Date日期对象

    常见方法：
    getTime() 返回从1970年1月1日 00:00:00走到此刻的总毫秒数
    setTime(long time) 设置日期对象的时间为当前时间毫秒值对应的时间
     */
    public static void main(String[] args) {
        Date date1 = new Date();
        System.out.println("空参构造，创建当前时间的Date对象：");
        System.out.println(date1);
        Date date2 = new Date(0);
        System.out.println("带参构造0");
        System.out.println(date2);
        System.out.println("返回从1970年1月1日 00:00:00走到对象时间的总毫秒数");
        System.out.println(date1.getTime());
        System.out.println("设置日期对象的时间为当前时间毫秒值对应的时间");
        date1.setTime(0);
        System.out.println(date1);
    }
}
