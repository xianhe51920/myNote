package website.fairycrane.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.format.annotation.DateTimeFormat;
import website.fairycrane.pojo.Emp;
import website.fairycrane.pojo.EmpQueryParam;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    // 查询员工总记录数
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
    Long count();
    // 分页查询,使用PageHelper依赖
//    @Select("select e.*,d.name from emp e join dept d on e.dept_id = d.id\n" +
//            "    where e.name like '%阮%' and e.gender=1 and e.entry_date between '2010-01-01' and '2020-01-01'\n" +
//            "    order by e.update_time desc")
    Page<Emp> list(EmpQueryParam empQueryParam);

    // 保存员工基本信息
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    void insert(Emp emp);
}