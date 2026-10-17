package website.fairycrane;

import website.fairycrane.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import website.fairycrane.pojo.User;

import java.util.List;

@SpringBootTest // springboot单元测试的注解 - 当前测试类中的测试方法运行时，会启动springboot项目 - IOC容器
class SpringbootMybatisQuickStartApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }

    @Test
    public void testDelete(){
        Integer i = userMapper.deleteUser(5);
        System.out.println("sql语句执行后影响的行数：" + i);
    }

    @Test
    public void testInsertUser(){
        User user = new User(null,"suoming","123456","锁暝",16);
        userMapper.insertUser(user);
    }

    @Test
    public void testUpdateUser(){
        User user = new User(1,"qingxiao","123456","清宵",22);
        userMapper.updateUser(user);
    }

    @Test
    public void testSelectUser(){
        User user = userMapper.selectUser("qingxiao", "123456");
        System.out.println("查询到的用户为" + user.getName() + "," + user.getAge() + "岁");
    }
}
