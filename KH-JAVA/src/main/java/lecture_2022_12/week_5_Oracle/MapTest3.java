package lecture_2022_12.week_5_Oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MapTest3 {
    // 회원정보 담기
    
    public static void main( String[] args ) {
        
        Map<String, Object>       fruitMap = new HashMap<>();
        List<Map<String, Object>> fruit    = new ArrayList<>();
        fruitMap.put( "mem_id", "tomato" );
        System.out.println( "1 = " + fruitMap );
        fruit.add( fruitMap );
        fruitMap = new HashMap();
        fruitMap.put( "mem_id", "apple" );
        fruitMap.put( "mem_pw", "jobs" );
        System.out.println( "2 = " + fruitMap );
        fruit.add( fruitMap );
        System.out.println( fruit.get( 0 ).get( "mem_id" ) );
        System.out.println( fruit.get( 1 ).get( "mem_id" ) );
        
    }
    
}
