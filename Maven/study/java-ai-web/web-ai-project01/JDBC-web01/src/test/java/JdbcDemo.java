import org.junit.jupiter.api.Test;
import website.fairycrane.pojo.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo {
    /*
    JDBC入门程序
     */
    @Test
    public void testJdbc() throws Exception {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/jdbc_web01";
        String user = "root";
        String password = "jh666666";
        Connection connection = DriverManager.getConnection(url, user, password);
        // 获取执行对象
        Statement statement = connection.createStatement();
        // 执行sql语句
        long i = statement.executeLargeUpdate("update user set age=25 where id = 1;");
        System.out.println("sql语句影响的行数为" + i);

        // 释放资源
        connection.close();
        statement.close();

    }

    @Test
    public void testSelect() throws Exception {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取数据库连接
        String url = "jdbc:mysql://localhost:3306/jdbc_web01";
        String user = "root";
        String password = "jh666666";
        Connection connection = DriverManager.getConnection(url, user, password);
        // 定义预编译sql语句：参数值用 ? 占位
        String sql = "select id,username,password,name,age from jdbc_web01.user where username = ? and password = ?;";
        // 获取预编译执行对象
        PreparedStatement ps = connection.prepareStatement(sql);
        // 设置参数：参数下标从1开始，按 ? 出现的顺序依次赋值
        ps.setString(1, "daqiao");
        ps.setString(2, "123456");
        // 执行查询
        ResultSet rs = ps.executeQuery();
        // 处理结果集：每一行记录封装为一个 User 对象
        List<User> userList = new ArrayList<>();
        while (rs.next()) {
            User u = new User();
            u.setId(rs.getInt("id"));
            u.setUsername(rs.getString("username"));
            u.setPassword(rs.getString("password"));
            u.setName(rs.getString("name"));
            u.setAge(rs.getInt("age"));
            userList.add(u);
        }
        // 输出到控制台
        for (User u : userList) {
            System.out.println(u);
        }
        // 释放资源：先开后关
        rs.close();
        ps.close();
        connection.close();
    }
}
