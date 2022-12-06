package java_b3_1205;

public class FibonacciSquence02 {
    
    public static void main( String[] args ) {
        
        int num1 = 1;
        int num2 = 1; // 1, 2 번째 값은 정해져 있는 값인 1, 1로 초기화
        int num3 = 0; // 세번째 값은 0으로 초기화 후 아래서 연산을 수행
        System.out.print( num1 + "," + num2 ); // 첫번째, 두번째 값 출력
        
        for ( int i = 0; i < 8; i++ ) {
            num3 = num1 + num2;
            System.out.print( "," + num3 );
            
            num1 = num2; // 두번째 수를 세번째 수로
            num2 = num3; // 현재의 수를 첫번째 수로
        }
    }
    
}
