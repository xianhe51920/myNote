package website.fairycrane.service;

import website.fairycrane.pojo.Clazz;
import website.fairycrane.pojo.ClazzQueryParam;
import website.fairycrane.pojo.PageResult;

import java.util.List;

public interface ClazzService {
    PageResult<Clazz> pageResult(ClazzQueryParam clazzQueryParam);

    void deleteById(Integer id);

    void addClazz(Clazz clazz);

    Clazz getClazzById(Integer id);

    void updateClazz(Clazz clazz);

    List<Clazz> getClszzList();
}
