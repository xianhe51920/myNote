package website.fairycrane.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import website.fairycrane.dao.UserDao;
import website.fairycrane.dao.impl.UserDaoImpl;
import website.fairycrane.pojo.User;
import website.fairycrane.service.UserService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

//@Component // 把实现类交给IOC容器管理
@Service
public class UserServiceImpl implements UserService {
    // 依赖注入
    // 1. 属性注入
//    @Autowired
//    private final UserDao userDao;

    // 2. 构造器注入
//    private final UserDao userDao;
//    public UserServiceImpl(UserDaoImpl userDaoImpl) {
//        this.userDaoImpl = userDaoImpl;
//    }

    // 3. setter注入
    private UserDao userDao;
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }



    @Override
    public List<User> getUsersData() {
        List<String> lines = userDao.getAll();
        List<User> userData = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name = parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime = LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id, username, password, name, age, updateTime);
        }).toList();
        return userData;
    }
}
