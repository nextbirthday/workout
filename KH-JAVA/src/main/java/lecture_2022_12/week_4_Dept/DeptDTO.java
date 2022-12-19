package lecture_2022_12.week_4_Dept;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class DeptDTO {
    private int    deptno;
    private String dName;
    private String loc;
}
