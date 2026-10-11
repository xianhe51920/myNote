package website.fairycrane.mapper;

import org.apache.ibatis.annotations.*;
import website.fairycrane.pojo.User;

import java.util.List;

@Mapper // 程序在运行时，会自动为该接口创建一个实现类对象（代理对象），并且会自动将该实现类对象存入IOC容器 - bean
public interface UserMapper {
    /**
     * 查询所有用户
     */
//    @Select("select * from user")
    List<User> findAll();

    /**
     * 删除指定id用户
     */
    @Delete("delete from user where id = #{id}")
    Integer deleteUser(Integer id);

    /**
     * 添加一个新用户
     */
    @Insert("insert into user(username, password, name, age) values (#{username},#{password},#{name},#{age})")
    void insertUser(User user);

    /**
     * 根据id修改用户信息
     */
    @Update("update user set username = #{username}, password = #{password}, name = #{name}, age = #{age} where id = #{id}")
    void updateUser(User user);


    /**
     * 查询指定用户
     * @param username 用户名
     * @param password 密码
     * @return 用户对象
     */
    @Select("select * from user where username = #{username} and password = #{password}")
    User selectUser(@Param("username") String username, @Param("password") String password);
}
