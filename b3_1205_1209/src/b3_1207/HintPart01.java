package b3_1207;

public class HintPart01 {
    // 선언부
    // 컴퓨터가 채번한 숫자를 담을 1차 배열 선언
    int[] com = new int[3];
    
    // 사용자가 입력한 문자열을 쪼개서 담을 1차 배열 선언
    int[] my = new int[3];
    
    // 회차를 담을 변수 선언
    int count = 0;
    
    // 새 게임 버튼을 누르면 3자리의 서로 다른 숫자를 채번한다.
    
    public void randomCom() {
        
        com[0] = ( int ) ( Math.random() * 10 );
        
        // 중복된 숫자를 제거하는 목적으로 do-while문을 선택하였다.
        do {
            com[1] = ( int ) ( Math.random() * 10 );
        } while ( com[0] == com[1] );
        
        do {
            com[2] = ( int ) ( Math.random() * 10 );
        } while ( com[0] == com[2] || com[1] == com[2] );
    }
    
    // 3자리 숫자를 입력 받아서 힌티문을 작성해주는 메서드 구현
    public String account( String user ) {
        
        if ( user.length() != 3 ) {
            return "3자리 숫자만 입력하세요."; // account 메서드 탈출하기
        }
        
        int temp   = 0; // 파라미터로 넘어온 사용자가 입력한 문자열 값을 정수형으로 변환 담기
        int strike = 0;
        int ball   = 0;
        
        try {
            temp = Integer.parseInt( user );
        }
        catch ( NumberFormatException e ) {
            return "숫자만 입력하세요.";
        }
        my[0] = temp / 100; // 256 / 100 -> 2.56 int/int -> 2
        my[1] = ( temp % 100 ) / 10; // 256을 100으로 나눈 나머지 56 /10 -> (int) 5.6
        my[1] = temp % 10; // 몫은 25이고 나머지는 6이다.
        
        for ( int i = 0; i < com.length; i++ ) {// 입력받은 숫자가 com 배열에 존재하니? 네~ ball, 아니오~ -제외
            
            for ( int j = 0; j < com.length; j++ ) {// 만일 위에서 네~ 라면 strike인지를 검사한다. com배열의 i자리와 my 배열의 j자리가 같니?
                // 숫자가 있어?
                
                if ( com[i] == my[j] ) {// ball은 확보, 자리가 같은지 비교하자, 자리도 같니?
                    // 같은 숫자가 있는지만 비교하고 자리가 달라도 참이다.
                    
                    if ( i == j ) {// 56번에서 비교한 숫자의 자리가 사용자가 입력받은 자리까지도 같은가? 같으면 strike 다르면 ball
                        strike++;
                    }
                    else {
                        ball++;
                    }
                } // 입력받은 숫자가 컴퓨터 채번한 숫자와 일치하는 경우
            }// end of inner for
            
        } // end of outter for
        
        if ( strike == 3 )
            return "정답입니다.";
        // strike variable value가 3이면 73번은 실행기회를 가지지 않는다.
        return strike + "strike" + ball + "ball";
    }
    
}
