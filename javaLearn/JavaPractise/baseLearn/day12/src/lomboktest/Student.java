package lomboktest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 重写类中的方法
@AllArgsConstructor // 写出带参构造方法
@NoArgsConstructor // 写出空参构造方法
public class Student {
    String name;
    int age;
}
