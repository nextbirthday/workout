package lecture_2022_12.week_4_List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class DepartmentDTO {
    private int    deptno;
    private String dname;
    private String loc;
}
