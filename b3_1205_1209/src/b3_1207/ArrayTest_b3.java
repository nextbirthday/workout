package b3_1207;

public class ArrayTest_b3 {
    /**
     * 1차원 배열을 선언하고 for 루프로 출력해본다
     * 
     * @author YOON
     */
    private static final int ARRAY_LENGTH = 3;
    
    public void printIntArray( int[] array ) { // parameter 활용, 재사용성
        
        System.out.println( "length = " + array.length );
        
        for ( int i = 0; i < array.length; i++ ) {
            System.out.println( "array[" + i + "]" + array[i] );
        }
        System.out.println( "end of printIntArray\n" );  // \n 한 줄 띄우기
    }
    
    public static void main( String[] args ) {
        ArrayTest_b3 test = new ArrayTest_b3();
        
        // new 연산자 사용하여 초기화
        int[] array0 = new int[10]; // 배열의 선언과 생성만 했을 뿐 초기화는 하지 않았다.
        test.printIntArray( array0 );
        
        int[] array1 = { 1, 2, 3, 4, 5 };
        test.printIntArray( array1 );
        
        // 어레이 타입에 맞는 상수를 바로 대입하여 초기화
        int[] array2 = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }; 
        test.printIntArray( array2 );
        
        //new 연산자 활용하여 초기화, 크기에 '변수' 사용
        int[] array3 = new int[ARRAY_LENGTH];
        array3[0] = 10;
        array3[1] = 20;
        array3[2] = 30;
       
        try {
            System.out.println( array3[3] ) ;
        }
        catch ( ArrayIndexOutOfBoundsException e ) {
            System.out.println( "array3 array index는 2까지 입니다." );
        }        
    }
}
