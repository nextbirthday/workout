package b3_1207;

import java.util.Scanner;

public class RanNum1_2 {
    int com = -1;
    // int my = -1;
    
    public void getRandomNumber() {
        com = ( int ) ( Math.random() * 10 ); // 10을 곱하는 이유는 구간을 늘리기 위해서
    }
    
    // userNumber 변수 때문에 변수 my를 삭제하였다.
    // 사용자가 입력한 값을 지역변수에 담아야 하는 이유에 대해 설명하시오.
    // ==> 게임이 진행되는 동안에 계속 바뀌어야 하니까
    // com 변수는 왜 전역변수 이어야만 하는지에 대해서도 설명하시오.
    // ==> 정답을 맞출 때까지는 값이 유지되어야 하니까
    
    public String account( int userNumber ) {
        
        String message = null;
        
        if ( com > userNumber ) {
            message = "높여라";
        }
        
        else if ( com < userNumber ) {
            message = "낮춰라";
            return message;
        }
        
        else if ( com == userNumber ) {
            message = "정답";
            // return message : if 문에서 해당 메서드를 탈출할 때 return예약어 사용 가능
            // 반복문에서는 break문을 사용한다.
        }
        return message;
    }
    
    public static void main( String[] args ) {
        RanNum1_2 rn = new RanNum1_2();
        rn.getRandomNumber(); // 실행하자마자 채번
        System.out.println( "채번한 숫자 ===>" + rn.com ); //컴퓨터가 채번한 숫자를 출력
        
        Scanner scan = new Scanner( System.in );
        System.out.println( "0~9 사이의 정수 하나를 입력하세요 : " );
        
        String user   = scan.nextLine();
        int    i_user = Integer.parseInt( user );
        
        
        
        
        
        
    }
    
}
