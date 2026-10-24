package website.fairycrane.service;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;
import website.fairycrane.pojo.Emp;
import website.fairycrane.pojo.EmpExpr;
import website.fairycrane.pojo.EmpQueryParam;
import website.fairycrane.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    // 返回PageResult对象
    PageResult<Emp> pageResult(EmpQueryParam empQueryParam);

    // 保存员工信息
    void save(Emp emp);
}
