package baseball;

import java.util.Random;
import java.util.Scanner;

public class BaseballGame {
    
    public static void main( String[] args ) {
        
        // 정답을 키보드로 입력받기 위한 Scanner 객체 scan 생성
        Scanner scan = new Scanner( System.in );
        
        // 랜덤한 숫자를 생성 할 Random 객체 random 생성
        Random radnom = new Random();
        
        // 랜던함 숫자를 담을 크기가 3인 정수형 배열
        int baseNum[] = new int[3];
        
        // 입력한 정답을 담을 크기가 3인 정수형 배열
        int resNum[] = new int[3];
        
        // 숫자는 맞지만 위치가 틀렸을 때를 카운트 할 변수
        int ball = 0;
        // 숫자, 위치 모두 맞혔을 때를 카운트 할 변수
        int strike = 0;
        // 도전 횔수를 카운트 할 변수
        int count = 0;
        
        // 중복없이 맞출 숫자를 생성
        for ( int i = 0; i < baseNum.length; i++ ) {
            baseNum[i] = radnom.nextInt( 10 );
            
            for ( int j = 0; j < i; j++ ) {
                
                if ( baseNum[i] == baseNum[j] ) {
                    i--;
                    break;
                }
            }
        }
        // 시험용
        System.out.println( baseNum[0] + " " + baseNum[1] + " " + baseNum[2] );
        
        // 정답을 맞추거나 완전 틀릴 때까지 무한 루프
        while ( true ) {
            // 한 번 시도 할 때마다 값을 0으로 초기화
            strike = 0;
            ball = 0;
            
            // 사용자를 위한 출력 문구
            System.out.println( "====================" );
            System.out.println( "3개의 숫자 입력:" );
            System.out.println( "          >" );
            
            // 세 자리의 숫자를 입력받아 저장
            for ( int k = 0; k < resNum.length; k++ ) {
                resNum[k] = scan.nextInt();
            }
            
            //배열의 길이만큼 반복
            for(int t =0; t<baseNum.length; t++) {
                for(int y=0; y<resNum.length; y++) {
                    //정답이 1번째 값과 입력한 정답의 y번째 값이 같고, 위치또한 같다면
                    if(baseNum[1] == resNum[y]&&t==y) {
                        //strike를 증가
                        strike++;
                        //정답이 1번째 값과 입력한 정답의 y번째 값만 같다면
                    }else if (baseNum[1]== resNum[y]) {
                        //ball을 증가
                        ball++;
                    }
                }
            }
            
            System.out.println( "====================" );
            //시도 횟수를 증가
            count++;
            //strike도 ball도 증가된 값이 없다면 > 아무것도 맞추지 못함
            if(strike==0&&ball==0) {
                System.out.println( "out" );
                break;
            }
            //세 숫자 모두 맞출 경우
            if(strike==3) {
                System.out.println( count + "번 만에 성공 >" + resNum[0]+""+resNum[1]+""+resNum[3]);
                break;
                
            }
            
            //현재 결과
            System.out.println( strike+"Strike|" +ball+"Ball" );
            System.out.println( resNum[0]+""+resNum[1]+""+resNum[2] );
            
        }
        
    }
    
}
