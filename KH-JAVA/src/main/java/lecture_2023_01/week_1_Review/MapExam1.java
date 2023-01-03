package lecture_2023_01.week_1_Review;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapExam1 {
    
    public static void main( String[] args ) {
        // List 따로 Map따로 사용하는 경우보다는 주로 List<Map<>> 형태로 사용된다.
        // 오라클에서 제공하는 테이블 구조에서 튜플을 구성할 때 Map을 사용 가능하다.
        // member table
        List<Map<String, Object>> memList = new ArrayList<>();
        Map<String, Object>       pMap    = new HashMap<>();
        
        pMap.put( "mem_id", "kiwi" );
        pMap.put( "mem_pw", "123" );
        pMap.put( "mem_nick", "나초보" );
        memList.add( pMap );
        
        pMap = new HashMap<>();
        pMap.put( "mem_id", "tomato" );
        pMap.put( "mem_pw", "123" );
        pMap.put( "mem_nick", "나신입" );
        memList.add( pMap );
        
        pMap = new HashMap<>();
        pMap.put( "mem_id", "apple" );
        pMap.put( "mem_pw", "123" );
        pMap.put( "mem_nick", "스티브" );
        memList.add( pMap );
        
        // Map의 key 값은 DB Table의 column name과 통일하기
        // ket value를 출력
        
        Object[] key = pMap.keySet().toArray();
        
        for ( Object object : key ) {
            System.out.println( object.toString() );
            System.out.println( pMap.get( object ) );
        }
        
        for ( int i = 0; i < memList.size(); i++ ) {
            System.out.println( memList.get( i ).get( "mem_id" ) + ", " + memList.get( i ).get( "mem_pw" ) + ", " + memList.get( i ).get( "mem_nick" ) );
        }
    }
}
