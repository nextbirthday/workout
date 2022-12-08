package b3_1207;

import java.util.Arrays;

public class ArrayTry01 {
    
    public static void main( String[] args ) {
        // 배열의 예외처리 - try, catch block
        int[] i; // array의 선언
        i = new int[3]; // array의 생성
        // 초기화가 안되었다. 아직 0,0,0
        // 객체배열 null,null,null
        // i[0] = 1; array index 0번 값 1로 초기화
        System.out.println( i[0] );
        i[1] = 5;
        
        try {
            // 문법 에러는 Exception과는 상관이 없다. - Run-time error
            // Exception이 발생할 가능성이 있는 코드를 감싼다.
            System.out.println( i[1] );
        }
        catch ( ArrayIndexOutOfBoundsException e ) {
            System.out.println( "index 범위를 벗어났습니다." );
        }
        System.out.println( "여기" );
    }
}