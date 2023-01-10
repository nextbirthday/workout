package b3_1216;

import java.util.Vector;

public class VectorSample05 {
    Vector<String[]> vectorDepts = new Vector<>();
    
    String[][] depts = { { "10", "개발부", "서울", "02-555-7788" }, { "20", "인사부", "인천", "032-333-9988" }, { "30", "총무부", "부산", "051-666-2233" } };
    
    void initVector() {
        
        for ( int i = 0; i < depts.length; i++ ) {
            vectorDepts.add( depts[i] ); // vector에 담기는 것은 1차 array이다. - column의 수는 바뀔 수 있다.
        }
    }
    
    void initVectorPrint() {
        
        for ( int i = 0; i < vectorDepts.size(); i++ ) {
            String[] oneRow = vectorDepts.get( i );
            System.out.println( oneRow.toString() );
            
            for ( int j = 0; j < oneRow.length; j++ ) {
                System.out.print( oneRow[j] + " " );
            }
            System.out.println();
        }
    }
    
    public static void main( String[] args ) {
        VectorSample05 test = new VectorSample05();
        test.initVector();
        test.initVectorPrint();
        System.out.println( test.vectorDepts.size() );
        
    }
}