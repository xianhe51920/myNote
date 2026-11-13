package website.fairycrane.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentParam {
    private String name;
    private Byte degree;
    private Integer clazzId;
    private Integer page;
    private Integer pageSize;
}
