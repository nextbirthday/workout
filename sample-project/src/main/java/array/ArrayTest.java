package array;

/**
 * 1차원 배열을 선언하고 for 루프로 출력해본다
 * 
 * @author geundu
 */
public class ArrayTest {
    
    private static final int ARRAY_LENGTH = 3;
    
    public void printIntArray( int[] array ) {
        System.out.println( "length = " + array.length );
        
        for ( int i = 0; i < array.length; i++ ) {
            System.out.println( "array[" + i + "] = " + array[i] );
        }
        System.out.println( "end of array\n" );
    }
    
    public static void main( String[] args ) {
        
        ArrayTest test = new ArrayTest();
        
        // new 연산자 사용하여 초기화
        int[] array0 = new int[10]; // 배열을 선언하고 생성까지 했다. 근데 값 초기화는 하지 않았다.
        test.printIntArray( array0 );
        
        int[] array1 = new int[ARRAY_LENGTH];
        test.printIntArray( array1 );
        
        int[] array2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        test.printIntArray( array2 );
        
        int[] array3 = new int[] { 10, 11, 12, 13, 14, 15 };
        test.printIntArray( array3 );
    }
}
