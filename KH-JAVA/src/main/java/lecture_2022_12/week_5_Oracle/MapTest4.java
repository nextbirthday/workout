package lecture_2022_12.week_5_Oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MapTest4 {
    // 회원정보 담기
    
    public static void main( String[] args ) {
        List<Map<String, Object>> accountList = new ArrayList<>();
        Map<String, Object>       accMap      = new HashMap<>();
        // id, nickname, password, gender
        // mem_id, mem_name, mem_pw, mem_gender
        // tomato, 토마토, 123, 남자
        // banana, 바나나, 1234, 여자
        // kiwi, 키위, 12345, 남자
        accMap.put( "mem_id", "tomato" );
        accMap.put( "mem_name", "토마토" );
        accMap.put( "mem_pw", "123" );
        accMap.put( "mem_gender", "남자" );
        accountList.add( accMap );
        
        log.info( accMap );
        log.info( accountList );
        System.out.println( accountList.get( 0 ) ); // Map 출력
        System.out.println( accountList.get( 0 ).get( "mem_name" ) );
        
        accMap = new HashMap();
        accMap.put( "mem_id", "banana" );
        accMap.put( "mem_name", "바나나" );
        accMap.put( "mem_pw", "1234" );
        accMap.put( "mem_gender", "여자" );
        accountList.add( accMap );
        
        accMap = new HashMap();
        accMap.put( "mem_id", "kiwi" );
        accMap.put( "mem_name", "키위" );
        accMap.put( "mem_pw", "12345" );
        accMap.put( "mem_gender", "남자" );
        accountList.add( accMap );
        
        for ( int i = 0; i < accountList.size(); i++ ) {
            System.out.println( accountList.get( i ) );
        }
    }
}
