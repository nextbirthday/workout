package b3_1212;

import java.util.Scanner;

public class EllipseArea {
    
    void radius( int riSmall, int riBig ) {
        final double PI = 3.1416;
        System.out.println( PI * riSmall * riBig );
    }
    
    public int biggerReturn( int a, int b ) {
        int result;
        
        if ( a > b ) {
            result = a;
        }
        else {
            result = b;
        }
        return result;
    }
    
    public void moonWeight() {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "몸무게를 입력해주세요 : " );
        double w = scanner.nextDouble();
        scanner.close();
        double moonWeight = w * 0.17;
        System.out.println( "달에서의 몸무게는" + moonWeight + "입니다." );
    }
    
    private void multiple( int first, int second ) {
        
        for ( int i = first; i <= second; i++ ) {
            
            if ( i % 3 == 0 ) {
                System.out.println( i + "는 3의 배수입니다." );
            }
        }
    }
    
    public static void main( String[] args ) {
        
        EllipseArea test = new EllipseArea();
        // test.radius( 15, 20 );
        // int result = test.biggerReturn( 5, 8 );
        // System.out.println( result );
        // test.moonWeight();
        test.multiple( 5, 15 );
    }
    
}
