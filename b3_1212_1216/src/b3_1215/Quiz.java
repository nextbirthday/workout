package b3_1215;

import java.util.Scanner;

public class Quiz {
    // 키보드로 부터 5개의 정수를 입력 받아서 배열에 저장하세요. - 이들의 합계와 평균을 출력하는 프로그램 작성
    void gradePrint() {
        
        int    total        = 0;
        double subjectCount = 5.0;
        double avg          = 0;
        int[]  score        = new int[5];
        
        Scanner scanner = new Scanner( System.in );
        
        for ( int i = 0; i < 5; i++ ) { // n번 입력받는 것을 for문을 활용해 코드를 간결하게 만들었음 
            System.out.println( "점수를 입력해주세요 : " );
            score[i] = scanner.nextInt();
            total += score[i];
        }
        avg = total / subjectCount;
        System.out.println( "총점은 : " + total + "입니다.\n" + "평균은 : " + avg + "입니다." );
        scanner.close();
    }
    
//    -10에서 10사이의 정수 10개를 랜덤하게 채번하여  음수와 양수의 합계를 구하는 프로그램을 작성하시오.
//    출력) 배열 : 9 -2 -3 8 0 -3 -8 -6 -2 0 / 음수합 : -24 , 양수합 : 17

    void randomNumberPrint() {
        int getRandomNumber = (int)(Math.random()*20 -10);
        int[] randomNumber = new int[10];
    }
    
    public static void main( String[] args ) {
        Quiz test = new Quiz();
        test.gradePrint();
    }
}
