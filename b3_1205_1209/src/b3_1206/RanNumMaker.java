package b3_1206;

import java.util.Arrays;

public class RanNumMaker {
    // 여기서 채번한 값을 다른 클래스에서 재사용해야 한다면 멤버변수로 선언한다.
    int[] com = new int[3];
    int[] my  = new int[3]; // 사용자가 선택한 숫자
    
    // random number 3서로 다른 숫자로된 값을 배열에 담기
    // 초기화, strike와 ball은 어떤 변수로 할지? 전역변수 or 지역변수
    // 자리가 같다는 것을 배열의 index를 활용하시오.
    public String account( String user_input ) {
        // insert here
        return user_input;
    }
    
    public static void main( String[] args ) {
        RanNumMaker rn = new RanNumMaker();
        
        for ( int i = 0; i < 10; i++ ) {
            
            System.out.println( rn.com[0] + "," + rn.com[1] + "," + rn.com[2] );
        }
    }
}
