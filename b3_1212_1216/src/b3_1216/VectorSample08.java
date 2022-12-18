package b3_1216;

import java.util.Vector;

public class VectorSample08 {
    
    public static void main( String[] args ) {
        
        DepartmentVO[] dVOS = new DepartmentVO[3]; // 객체 배열
        // 배열 안에 들어있는 type가 object / dVOS[0] = new DepartmentVO ???
        Vector<DepartmentVO> vectorDepts = new Vector<>();
        
        DepartmentVO dvo = new DepartmentVO( 10, "개발부", "서울" );
        dVOS[0] = dvo;
        vectorDepts.add( dvo );
        
        dvo = new DepartmentVO( 20, " 인사부", "인천" );
        dVOS[1] = dvo;
        vectorDepts.add( dvo );
        
        dvo = new DepartmentVO( 30, " 총무부", "부산" );
        dVOS[2] = dvo;
        vectorDepts.add( dvo );
        
//        dvo = new DepartmentVO( 40, " 수송부", "천안" );
//        dVOS[3] = dvo; Array의 장애
//        vectorDepts.add( dvo );
        
    }
}