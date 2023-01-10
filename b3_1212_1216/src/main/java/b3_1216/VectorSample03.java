package b3_1216;

import java.util.Vector;

// int index = vector.indexOf( "바나나" ); 몇 번째 인덱스에 해당하는 값을 리턴
public class VectorSample03 {
    
    public static void main( String[] args ) {
        
        // Vector<String> vector = new Vector<>( Arrays.asList( "키위", "포도", "메론", "바나나", "복숭아" ) );
        // System.out.println( vector );
        
        String[] fruits  = { "키위", "포도", "사과", "토마토", "메론", "파인애플", "바나나", "복숭아" };
        String[] myFruit = { "키위", "포도", "메론", "바나나", "복숭아", "딸기", "체리" };
        
        Vector<String> vfruits = new Vector<>();
        
        for ( int i = 0; i < fruits.length; i++ ) {
            
            for ( int j = 0; j < myFruit.length; j++ ) {
                
                if ( fruits[i].equals( myFruit[j] ) ) {
                    vfruits.add( fruits[i] );
                }
                
                if ( !vfruits.contains( "딸기" ) ) {
                    vfruits.add( "딸기" );
                }
                
                if ( !vfruits.contains( "체리" ) ) {
                    vfruits.add( "체리" );
                }
            }
        }
        System.out.print( "favorite fruits = " );
        
        for ( String f : vfruits ) {
            System.out.print( f + " " );
        }
        System.out.println();
        System.out.println( vfruits );
    }
}
