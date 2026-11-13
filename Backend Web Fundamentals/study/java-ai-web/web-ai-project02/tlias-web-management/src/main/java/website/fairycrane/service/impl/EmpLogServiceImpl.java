package website.fairycrane.service.impl;

import website.fairycrane.mapper.EmpLogMapper;
import website.fairycrane.pojo.EmpLog;
import website.fairycrane.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW) //无论如何，该任务都要在新的事物中运行
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
