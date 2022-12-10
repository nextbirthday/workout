package b3_1205;

import java.util.Scanner;

public class Quiz03While {
    
    public static void main( String[] args ) {
        Quiz03While quiz03While = new Quiz03While();
        quiz03While.sumEvenWhile();
    }
    
    void sumEvenWhile() {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "구하고자 하는 합의 두번 째 숫자를 입력하세요.>" );
        
        int user_end = scanner.nextInt();
        int sum      = 0;
        int cnt      = 1;
        
        while ( cnt <= user_end ) {
            
            if ( cnt % 2 == 0 ) {
                sum += cnt;
            }
            cnt++; // 증감식
        }
        System.out.printf( "sum : %d, cnt : %d %n", sum, cnt );
        // System.out.println( "sum" + sum + "," + "cnt" + cnt );
        scanner.close();
    }
    
}
