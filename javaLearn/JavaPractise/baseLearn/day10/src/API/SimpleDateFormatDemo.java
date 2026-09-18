package API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    /*
    SimpleDateFormat类：
    构造器：
    SimpleDateFormat() 构造一个SimpleDateFormat，使用默认格式
    SimpleDateFormat(String pattern) 构造一个SimpleDateFormat，使用指定的格式

    格式化方法：
    format(Date date) 将日期格式化成日期/时间字符串
    parse(String source) 将字符串解析为日期类型
     */
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date now = new Date();

        // 将Date对象格式化字符串
        System.out.println("将Date对象格式化字符串");
        String res = sdf.format(now);
        System.out.println(res);
        // 将字符串解析为日期类型
        try {
            System.out.println("转换成功 ");
            System.out.println(sdf.parse("2025年11月23日 12:00:00"));
        } catch (ParseException e) {
            System.out.println("转换失败");
        }
    }
}
