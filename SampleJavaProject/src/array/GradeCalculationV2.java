package array;

import java.util.ArrayList;
import java.util.List;

public class GradeCalculationV2 {
    
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
        GradeCalculationV2 gcv2         = new GradeCalculationV2();
        List<StudentScore> data         = new ArrayList<StudentScore>();
        StudentScore       studentScore = new StudentScore();
        
        studentScore.setStudentName( "이순신" );
        studentScore.setJavaScore( 80 );
        studentScore.setDbScore( 75 );
        studentScore.setLinuxScore( 70 );
        data.add( studentScore );
        
        studentScore = new StudentScore();
        studentScore.setStudentName( "강감찬" );
        studentScore.setJavaScore( 90 );
        studentScore.setDbScore( 85 );
        studentScore.setLinuxScore( 95 );
        data.add( studentScore );
        
        studentScore = new StudentScore();
        studentScore.setStudentName( "김춘추" );
        studentScore.setJavaScore( 65 );
        studentScore.setDbScore( 60 );
        studentScore.setLinuxScore( 60 );
        data.add( studentScore );
        
        gcv2.calc( data );
    }
}
