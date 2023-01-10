package b3_1216;

import java.util.Vector;

public class VectorSample02 {
    public static void main( String[] args ) {
        
        String[]       fruits  = { "키위", "포도", "사과" };
        
        Vector<String> vfruits = new Vector<>();
        
        for ( int i = 0; i < fruits.length; i++ ) {
            vfruits.add( i, fruits[i] );
        }
        
        System.out.println( vfruits.size() );
        vfruits.add( 1, "토마토" );
        
        for ( int i = 0; i < vfruits.size(); i++ ) {
            System.out.println( vfruits.get( i ) );
        }
        System.out.println();
        System.out.println( vfruits.remove( 2 ) + "\n" );
        
        for ( int i = 0; i < vfruits.size(); i++ ) {
            
            if ( vfruits.get( i ).equals( "포도" ) ) {
                vfruits.remove( i );
            }
            
            if ( vfruits.contains( "포도" ) ) {
                vfruits.remove( "포도" );
            }
            System.out.println( vfruits.get( i ) );
        }
        
    }
}
