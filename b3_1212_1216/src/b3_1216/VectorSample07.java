package b3_1216;

import java.util.Vector;

public class VectorSample07 {
    
    public static void main( String[] args ) {
        DepartmentVO[]       dVOS        = new DepartmentVO[3]; //객체 배열
        // 배열 안에 들어있는 type가 object / dVOS[0] = new DepartmentVO ???
        Vector<DepartmentVO> vectorDepts = new Vector<>();
        
        DepartmentVO dvo = new DepartmentVO( 10, "개발부", "서울" );
        dVOS[0] = dvo;
        vectorDepts.add( 0, dvo );
        
        dvo = new DepartmentVO( 20, " 인사부", "인천" );
        dVOS[1] = dvo;
        vectorDepts.add( 1, dvo );
        
        dvo = new DepartmentVO( 30, " 총무부", "부산" );
        dVOS[2] = dvo;
        vectorDepts.add( 2, dvo );
        // for ( int i = 0; i < vectorDepts.size(); i++ ) {
        // String[] oneRow = vectorDepts.get( i );
        // System.out.println( oneRow.toString() );
        //
        // for ( int j = 0; j < oneRow.length; j++ ) {
        // System.out.print( oneRow[j] + " " );
        // }
        
        for ( int i = 0; i < vectorDepts.size(); i++ ) {
            dVOS[i] = vectorDepts.get( i );
            System.out.println( dVOS );
            
            for ( int j = 0; j < dVOS.length; j++ ) {
                System.out.print( dVOS[j] + " " );
            }
        } 
    }
}