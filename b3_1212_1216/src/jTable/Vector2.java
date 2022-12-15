package jTable;

import java.util.Vector;

public class Vector2 {
    
    public static void main( String[] args ) {
        
        Vector<String> vector =new Vector<>();
        
        vector.add( "사과" );
        vector.add( "토마토" ); // 이것도 출력되네?
        vector.add( 1, "banana" ); // 끼워넣기 - Array는 불가능
        for(int i =0; i<vector.size();i++) {
            System.out.println( vector.get( i ) );
        }
    }
}
