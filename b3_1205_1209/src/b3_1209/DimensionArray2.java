package b3_1209;

public class DimensionArray2 {
    
    void multiDimensionArray( int[][] array ) {
        
        for ( int i = 0; i < array.length; i++ ) {
            
            for ( int j = 0; j < array[i].length; j++ ) {
                // System.out.println( "array[" + i + "][" + j + "]=" + array[i][j] );
                // System.out.println( Arrays.toString( array ) );
            }
        }
    }
    
    void multiDimensionArray( String[][] arrayStr ) {
        
        for ( int i = 0; i < arrayStr.length; i++ ) {
            
            for ( int j = 0; j < arrayStr[i].length; j++ ) {
                System.out.println( "arrayStr[" + i + "][" + j + "]=" + arrayStr[i][j] );
            }
        }
    }
    
    public static void main( String[] args ) {
        DimensionArray2 test = new DimensionArray2();
        
        int[][] array = new int[4][];
        
        array[0] = new int[] { 0, 1, 2 };
        array[1] = new int[] { 3, 4, 5, 6 };
        array[2] = new int[] { 7, 8, 9, 10, 11 };
        array[3] = new int[] { 12, 13, 14, 15, 16, 17, 18, 19, 20 };
        
        test.multiDimensionArray( array );
        //test.multiDimensionArray( null );
        /*
         * int[][] arr = new int[3][3];
         * // arr[0] = new int[3];
         * arr[0] = new int[] { 1, 2, 3 };
         * // arr[1] = new int[3];
         * arr[1] = new int[] { 4, 5, 6 };
         * // arr[2] = new int[3];
         * arr[2] = new int[] { 7, 8, 9 };
         * // insert here
         * System.out.println( arr[1][1] );
         */
        
    }
}
