package lecture_2022_12.week_5_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

class S1 {
    int age = 30;
}

class S2 {
    String animal = "tiger";
    int    leg    = 4;
}

class S3 {
    
}

public class MapTest1 {
    List<Map<String, Object>> list;
    
    public static void main( String[] args ) {
        MapTest1 mt = new MapTest1();
        // mt.list = new ArrayList<Map<String, Object>>();
        S1                  s1   = new S1();
        Map<String, Object> map3 = new Hashtable<>();
        
        System.out.println( "s1.age = " + s1.age );
        // S2 s2 = new S2();
        Map<String, Object> map1 = new HashMap<>();
        map1.put( "s1", s1 );
        S1 s2 = ( S1 ) map1.get( "s1" );
        System.out.println( s2.age );
        
        Map<String, Object> map2 = new HashMap<>();
        S2                  s3   = new S2();
        map2.put( "s2", s3 );
        S2 s4 = ( S2 ) map2.get( "s2" );
        
        if ( s4.animal instanceof String ) {
            System.out.println( "String type" );
            System.out.println( s4.animal );
        }
        
        if ( new Integer( s4.leg ) instanceof Integer ) {
            System.out.println( "Integer type" );
            System.out.println( s4.leg );
        }
        
    }
}
