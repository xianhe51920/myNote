package website.fairycrane.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import website.fairycrane.pojo.EmpExpr;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    // 保存员工工作经历
    void insert(List<EmpExpr> exprList);

    // 删除员工工作经历
    void deleteByEmpId(List<Integer> idList);
}
