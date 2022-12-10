package b3_1209;

public class DimensionArray {
    // 2차 배열 -> List<Map<>> Generic -> web, app, hybrid
    
    void toWhile( int[][] arr ) {
        
        System.out.println( "=========[while 문으로]==========" );
        int i = 0;
        
        while ( i < arr.length ) {
            // why??
            int j = 0;
            
            while ( j < arr[i].length ) {
                System.out.println( "arr[" + i + "][" + j + "]=" + arr[i][j] );
                j++;
            }
            i++;
        }
    }
    
    void toFor( int[][] arr2 ) {
        
        for ( int i = 0; i < arr2.length; i++ ) {
            for ( int j = 0; j < arr2[i].length; j++ )
                System.out.println( "arr[" + i + "][" + j + "]=" + arr2[i][j] );
        }
    }
    
    public static void main( String[] args ) {
        
        DimensionArray test = new DimensionArray();
        int[][]        arr  = new int[3][4];
        int[][]        arr2 = new int[5][6];
        test.toFor( arr2 );
        test.toWhile( arr );
    }
}
