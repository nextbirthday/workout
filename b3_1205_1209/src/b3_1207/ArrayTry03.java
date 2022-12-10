package b3_1207;

import java.util.Arrays;

public class ArrayTry03 {
    
    public static void main( String[] args ) {
        // 바로 실행해보기 보다는 결과 예측해보기
        int[] i = { 1, 2, 3 };
        int[] j; // array의 선언만 아직 생성은 하지 않았다.
        j = i; // 주소번지??
        int[] k = new int[5];
        // int[] k = {1,2,3,4,5}; array 선언과 생성과 초기화를 한 번에
        // insert here
        j = k; // 왜 에러??
        
        System.out.println( Arrays.toString( j ) );
        System.out.println( j.length );
        
    }// end of main
}