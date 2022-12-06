package java_b3_1206;

import java.util.Arrays;

public class ArrayEx02 {
    
    public static void main( String[] args ) {
        // int[] deptnos; 배열의 선언
        // deptnos = new int[3]; //배열의 생성
        // deptnos = new int[] {0,0,1}; 생성과 초기화를 동시에
        // int[] deptnos = {1024, 2048, 5096}; 배열의 선언과 생성과 초기화를 동시에(new예약어 없이)
        String[] deptNames = { "인사팀", "영업1팀", "영업2팀" };
        double[] piNumbers = { 1.0, 2.0, 3.0, 4.0, 5, 0 };
        System.out.println( Arrays.toString( deptNames ) );
        System.out.println( Arrays.toString( piNumbers ) );
    }
    
}
