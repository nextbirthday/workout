package lecture_2022_12.week_5_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest2 {
    
    public static void main( String[] args ) {
        
        List<Map<String, Integer>> list = new ArrayList<>();
        
        Map<String, Integer> map1 = new HashMap<>();
        map1.put( "one", 1 );
        map1.put( "two", 2 );
        map1.put( "three", 3 );
        
        Map<String, Double> map2 = new HashMap<>();
        map2.put( "five", new Double( 5 ) );
        map2.put( "six", new Double( 6 ) );
        map2.put( "seven", 7.0 );
        
        Map<String, Object> map3 = new HashMap<>();
        map3.put( "eight", 8 );
        map3.put( "nine", 9 );
        map3.put( "ten", 10.0 );
    }
}
