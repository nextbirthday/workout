package lecture_2022_12.week_4_List;

import java.util.List;
import java.util.Vector;

public class VectorSample {
    
    // List<e> 서로 다른 타입을 담을 수 있다.
    // Vector는 multi - thread에서 안전 (ArrayList에 비해 속도는 느리다.)
    // ArrayList는 single- thread에서 안전( Vector에 비해 속도는 빠르다.)
    
    public static void main( String[] args ) {
        // 2중 for문의 구조 [out = List-size(), inner = String[] - length]
        // 끼워넣기가 가능, 수정에 대한 API 제공은 없다. 클라우드 기반 데이터베이스 제품이 이런식
        List<String[]> list  = new Vector<>();
        String[]       temp  = { "0", "1", "2", "3", "4" };
        String[]       temp2 = { "하나", "둘", "셋", "넷" };
        list.add( temp );
        list.add( temp2 );
        
        List<String> listStr = new Vector<>(); // 단일 for문 처리
        listStr.add( "null" );
        
        try {
            
            for ( int i = 0; i < list.size(); i++ ) {// row의 수
                String[] result = list.get( i );
                
                for ( int j = 0; j < temp.length; j++ ) { // column의 수
                    System.out.print( result[j] + " " );
                }
                System.out.println();
            }
        }
        catch ( ArrayIndexOutOfBoundsException e ) {
            System.out.println( e.getMessage() );
        }
        
        for ( int i = 0; i < listStr.size(); i++ ) {
            System.out.println( listStr.get( i ) );
            
        }
    }
}
