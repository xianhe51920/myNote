package website.fairycrane.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String no;
    private Byte gender;
    private String phone;
    private Byte degree;
    private String idCard;
    private Byte isCollege;
    private String address;
    private LocalDate graduationDate;
    private Byte violationCount;
    private Byte violationScore;
    private Integer clazzId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String clazzName;
}
