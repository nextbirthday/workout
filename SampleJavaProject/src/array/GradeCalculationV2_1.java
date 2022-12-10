package array;

import java.util.ArrayList;
import java.util.List;

public class GradeCalculationV2_1 {
    
    public void calc( List<StudentScore> data ) {
        
        double    javaSum      = 0;
        double    dbSum        = 0;
        double    linuxSum     = 0;
        final int subjectCount = 3;
        
        for ( StudentScore studentScore : data ) {
            System.out.println( studentScore.getStudentName() + "의 성적" );
            double sum = studentScore.getJavaScore() + studentScore.getDbScore() + studentScore.getLinuxScore();
            System.out.println( "총점 : " + sum );
            System.out.println( "평균 : " + ( sum / subjectCount ) + "\n" );
            
            javaSum += studentScore.getJavaScore();
            dbSum += studentScore.getDbScore();
            linuxSum += studentScore.getLinuxScore();
        }
        System.out.println( "과목별 총점 및 평균\nJAVA 총점 : " + javaSum + ", 평균 : " + ( javaSum / data.size() ) + "\nDB 총점 : " + dbSum + ", 평균 : " + ( dbSum / data.size() )
                        + "\nLinux 총점 : " + linuxSum + ", 평균 : " + ( linuxSum / data.size() ) );
    }
    
    public static void main( String[] args ) {
        GradeCalculationV2_1 gcv2 = new GradeCalculationV2_1();
        List<StudentScore>   data = new ArrayList<StudentScore>();
        
        data.add( new StudentScore( "이순신", 80, 75, 70 ) );
        data.add( new StudentScore( "강감찬", 90, 85, 95 ) );
        data.add( new StudentScore( "김춘추", 65, 60, 60 ) );
        gcv2.calc( data );
    }
}
