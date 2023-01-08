package ternary;

import java.util.Arrays;
import java.util.List;

public class Ternary {
    
    private static String ternaryOperate( List<? extends Number> list ) {
        String  trueStr = "", falseStr = "";
        boolean isEmpty = false;
        
        if ( list != null && list.size() > 0 ) {
            
            for ( Number number : list ) {
                trueStr += number.toString() + " ";
            }
        }
        else {
            falseStr = "empty";
            isEmpty = true;
        }
        return !isEmpty ? trueStr : falseStr;
    }
    
    public static void main( String[] args ) {
        List<Integer> intList1 = Arrays.asList( 0, 1, 2, 3, 4, 5, 6, 7 );
        String        rtn1     = Ternary.ternaryOperate( intList1 );
        System.out.println( "rtn1 = " + rtn1 );
        
        List<Integer> intList2 = Arrays.asList();
        String        rtn2     = Ternary.ternaryOperate( intList2 );
        System.out.println( "rtn2 = " + rtn2 );
    }
}
