package b3_1216;

import java.util.Vector;

public class VectorSample {
    public static void main( String[] args ) {
        // 객체는 생성되었으나 방은 없다.
        Vector<Integer> vector = new Vector<>();
        
        System.out.println( vector.size() ); //0
        
        boolean isExist = vector.add( 1 ); // add 했을 때 방이 생성된다.
        System.out.println( vector.get( 0 ) ); // 1
        System.out.println( isExist ); // true
        System.out.println( vector.isEmpty() ); // false
        System.out.println( vector.contains( 1 ) ); // true
        System.out.println( vector.contains( 2 ) ); // false
        vector.add( 1, 2 ); 
        System.out.println( vector.contains( 2 ) ); // true
        System.out.println( vector.remove( 1 ) ); // 삭제된 object (E)를 반환
//        boolean isOk = vector.remove( new Integer( 1 ) );
        System.out.println( vector.size() ); // 1
        
//        System.out.println( isOk );
        
    }
}
