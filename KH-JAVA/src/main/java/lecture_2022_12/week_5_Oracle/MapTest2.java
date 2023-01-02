package lecture_2022_12.week_5_Oracle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class MapTest2 {
    
    public void setMap() {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object>       rMap = new HashMap<>();
        rMap.put( "deptno", 10 );
        rMap.put( "dname", "인사팀" );
        rMap.put( "loc", "서울" );
        list.add( rMap ); // list.get(0)
        
        rMap = new HashMap<>();
        rMap.put( "deptno", 20 );
        rMap.put( "dname", "총무팀" );
        rMap.put( "loc", "역삼" );
        list.add( rMap ); // list.get(1)
        
        rMap = new HashMap<>();
        rMap.put( "deptno", 30 );
        rMap.put( "dname", "데이터팀" );
        rMap.put( "loc", "판교" );
        list.add( rMap ); // list.get(2)
    }
    
    private List<Map<String, Object>> setTeam() {
        List<Map<String, Object>> teamList = new ArrayList<>();
        Map<String, Object>       tMap     = new HashMap<>();
        
        tMap.put( "deptno", 10 );
        tMap.put( "dname", "인사팀" );
        tMap.put( "loc", "SK 타워" );
        teamList.add( tMap );
        
        tMap = new HashMap();
        tMap.put( "deptno", 20 );
        tMap.put( "dname", "전산팀" );
        tMap.put( "loc", "SK C&C 타워" );
        teamList.add( tMap );
        
        
        
        
        return teamList;
    }
    
    public void mapPrint() {
        List<Map<String, Object>> teamList = new ArrayList<>();
        
        teamList = setTeam();
        
        // 각 로우안에 key가 세 개 있다. ( col - deptno, dname, loc)
        // Map m1 = get(0); col 3 Map m2 = get(1); col 3 Map m3 = get(2); col 3
        for ( int i = 0; i < teamList.size(); i++ ) {
            Map<String, Object> m1 = teamList.get( i );
            // 컬럼의 수를 반복해서 출력하기
            Object[] keys = m1.keySet().toArray();
            
            for ( int j = 0; j < keys.length; j++ ) {
                String key = ( String ) keys[j];
                System.out.print( m1.get( key ) + " " );
            }
            System.out.println();
        }
    }
    
    public static void main( String[] args ) {
        MapTest2                  mt2      = new MapTest2();
        List<Map<String, Object>> tempList = new ArrayList<>();
        tempList = mt2.setTeam();
        System.out.println( tempList );
        
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
