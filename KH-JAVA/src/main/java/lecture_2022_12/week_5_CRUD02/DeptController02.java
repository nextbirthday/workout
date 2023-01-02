package lecture_2022_12.week_5_CRUD02;

import java.util.List;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class DeptController02 {
    DeptModel02 model2 = new DeptModel02();
    
    int cudDept() {
        int result = 0;
        
        return result;
    }
    
    protected List<DeptVO02> getDept() { return model2.selectDept(); }
    
    
}
