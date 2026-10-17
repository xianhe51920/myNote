package website.fairycrane.dao.impl;

import cn.hutool.core.io.IoUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import website.fairycrane.dao.UserDao;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

//@Component // 把实现类交给IOC容器管理
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public List<String> getAll() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readLines(is, StandardCharsets.UTF_8, new ArrayList<>());
        return lines;
    }
}
