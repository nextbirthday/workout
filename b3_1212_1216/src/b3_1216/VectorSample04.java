package b3_1216;

import java.util.Vector;

public class VectorSample04 {
    public static void main( String[] args ) {
        
        String[][] depts = { { "10", "개발부", "서울", "02-555-7788" },  { "20", "인사부", "인천", "032-333-9988" }, { "30", "총무부", "부산", "051-666-2233" } };
        
      
        Vector<String[]> vectorDepts = new Vector<>();
        
        for ( int i = 0; i < depts.length; i++ ) {
            vectorDepts.add( depts[i] );
        }
        
        for ( int i = 0; i < vectorDepts.size(); i++ ) {
            String[] oneRow = vectorDepts.get( i );
            
            for ( int j = 0; j < oneRow.length; j++ ) {
                System.out.println( oneRow[j] + " " );
            }
            System.out.println();
        }
        
    }
}