package b3_1215;

import java.util.Scanner;

public class GradeScore {
    
    static final int MAX          = 100;
    int              subjectCount = 5;
    int              total        = 0;
    double           average      = 0.0;
    int[]            score        = new int[subjectCount];
    
    void scoreCalc() {
        Scanner scanner = new Scanner( System.in );
        
        for ( int i = 0; i < score.length; i++ ) {
            System.out.println( "점수를 입력해주세요." );
            score[i] += scanner.nextInt();
            total += score[i];
        }
        average = total / subjectCount;
        System.out.println( "총점 : " + total + " 평균 : " + average  );
    }
    
    public static void main( String[] args ) {
        GradeScore test = new GradeScore();
        test.scoreCalc();
    }
    
}
