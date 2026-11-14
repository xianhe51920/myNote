package website.fairycrane.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import website.fairycrane.mapper.EmpMapper;
import website.fairycrane.pojo.JobOption;
import website.fairycrane.service.ReportService;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    private EmpMapper empMapper;

    // 统计各个职位员工人数
    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        List<String> jobList = list.stream().map(dataMap -> (String)dataMap.get("pos")).toList();
        // count(*) 在 MySQL 中是 BIGINT，JDBC 驱动映射为 Long
        List<Long> dataList = list.stream().map(dataMap -> (Long) dataMap.get("num")).toList();
        return new JobOption(jobList,dataList);


    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        // 统计员工性别人数
        return empMapper.countEmpGenderData();
    }
}
