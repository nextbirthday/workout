package lecture_2022_12.week_5_Polymorphism;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import lombok.extern.log4j.Log4j2;

@Log4j2
// interface
// 단독으로는 인스턴스화 할 수 없다.
// 결합도를 낮춰주는 코드를 전개할 수 있도록 해준다.
public class ListMethod {
    
    void m( List<String> myNames ) {
        System.out.println( "==========[[List<String]]=========" );
        
        for ( String string : myNames ) {
            System.out.println( string );
        }
    }
    
    void m2( Vector<String> myNames ) {
        System.out.println( "==========[[Vector<String]]=========" );
        log.info( myNames.toString() );
        
        for ( String string : myNames ) {
            System.out.println( string );
        }
    }
    
    public static void main( String[] args ) {
        
        ListMethod          poly        = new ListMethod();
        List<String> nickNames3 = new Vector<>();
        nickNames3.add( "사자" );
        nickNames3.add( "호랑이" );
        nickNames3.add( "표범" );
        
        ArrayList<String> nickNames = new ArrayList<>();
        nickNames.add( "토마토" );
        nickNames.add( "키위" );
        nickNames.add( "사과" );
        
        Vector<String> nickNames2 = new Vector<>();
        nickNames2.add( "바나나" );
        nickNames2.add( "포도" );
        nickNames2.add( "딸기" );
        poly.m( nickNames );
        poly.m( nickNames3 );
        
        // myB.m2( nickNames );
        poly.m( nickNames2 );
        poly.m2( nickNames2 );
    }
}
