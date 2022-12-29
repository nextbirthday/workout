package lecture_2022_12.week_5_Oracle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MapTest {
    
    Map<Integer, Object> iMap = new HashMap<>();
    
    Map<String, Object> rMap = new HashMap<>();
    
    public void setiMap() {
        iMap.put( 10, 100 );
        iMap.put( 20, 200 );
        iMap.put( 30, 300 );
        iMap.put( 40, 400 );
        iMap.put( 50, 500 );
    }
    
    public void setMap() {
        rMap.put( "deptno", 10 );
        rMap.put( "dname", "인사팀" );
        rMap.put( "loc", "서울" );
        rMap.put( "loc", "부산" ); // overwrite
    }
    
    public static void main( String[] args ) {
        MapTest mt = new MapTest();
         log.info( mt.rMap.size() );
         mt.setMap();
        
         // Map에서 제공하는 메서드 중에서 key값을 묶음처리하는 메서드가 있다.
         Set<String> set = mt.rMap.keySet();
         log.info( mt.rMap.size() ); // 0->3
        
         // Set interface가 제공하는 메서드 중에서 toArray()를 지원한다.
         Object[] object = set.toArray();
        
         for ( int i = 0; i < object.length; i++ ) { // object.length는 배열의 원소 수 - 3개 - deptno, dname, loc
         String key = ( String ) object[i]; // 배열에서 꺼낸 값은 key 값이다. deptno, dname, loc
         System.out.println( "key : " + key ); // 3번 출력 - 순서가 맞지 않다.
         }
         Iterator<String> iter = set.iterator();
        
         while ( iter.hasNext() ) { // 자료구조안에 값이 있는지 체크해서 있으면 true를 반환, 없으면 false
         String key = iter.next();
         System.out.println( key );
         log.info( key );
         Object value = mt.rMap.get( key );
         System.out.println( key + ":" + value );
         log.info( key + ":" + value );
         }
         log.info( set.toString() );
        
        mt.setiMap();
        System.out.println( mt.iMap.size() );
    }
}
