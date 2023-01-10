package b3_1215;

import java.util.Scanner;

public class Quiz02 {
    int totalPrice;
    int customerTotalPrice;
    
    void receipt( int totalPrice, int stuffNumber ) {
               
        System.out.println( "영수증의 총 가격은" + totalPrice + "입니다.\n" + "구매하신 물품의 단위 수는 : " + stuffNumber + "입니다." );
        Scanner scanner = new Scanner( System.in );
        
        for ( int i = 1; i <= stuffNumber; i++ ) {
            System.out.println( "물건의 가격을 입력해 주세요." );
            int stuffPrice = scanner.nextInt();
            System.out.println( "물건의 개수를 입력해주세요" );
            int stuffNum = scanner.nextInt();
            customerTotalPrice += stuffPrice * stuffNum;
        }

        if ( totalPrice == customerTotalPrice ) {
            System.out.println( "Yes!" );
        }
        else {
            System.out.println( "NO!" );
        }
        scanner.close();
    }
        
    void intNumber() {
        
    }
    
    public static void main( String[] args ) {
        Quiz02 test = new Quiz02();
        test.receipt( 260000, 4 );
    }
}
