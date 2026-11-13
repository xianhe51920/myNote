package website.fairycrane.service;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;
import website.fairycrane.pojo.*;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    // 返回PageResult对象
    PageResult<Emp> pageResult(EmpQueryParam empQueryParam);

    // 保存员工信息
    void save(Emp emp);

    // 根据id删除员工信息
    void delete(List<Integer> ids);

    Emp getInfoById(Integer id);

    void update(Emp emp);

}
