package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GradeCalculationV3 {
    
    public void calc( List<Map<String, Object>> data ) {
        
        double    javaSum      = 0;
        double    dbSum        = 0;
        double    linuxSum     = 0;
        final int subjectCount = 3;
        
        for ( Map<String, Object> studentScore : data ) {
            System.out.println( studentScore.get( "studentName" ) + "의 성적" );
            double sum = Double.parseDouble( String.valueOf( studentScore.get( "javaScore" ) ) ) + Double.parseDouble( String.valueOf( studentScore.get( "dbScore" ) ) )
                            + Double.parseDouble( String.valueOf( studentScore.get( "linuxScore" ) ) );
            System.out.println( "총점 : " + sum );
            System.out.println( "평균 : " + ( sum / subjectCount ) + "\n" );
            
            javaSum += Double.parseDouble( String.valueOf( studentScore.get( "javaScore" ) ) );
            dbSum += Double.parseDouble( String.valueOf( studentScore.get( "dbScore" ) ) );
            linuxSum += Double.parseDouble( String.valueOf( studentScore.get( "linuxScore" ) ) );
        }
        System.out.println( "과목별 총점 및 평균\nJAVA 총점 : " + javaSum + ", 평균 : " + ( javaSum / data.size() ) + "\nDB 총점 : " + dbSum + ", 평균 : " + ( dbSum / data.size() )
                        + "\nLinux 총점 : " + linuxSum + ", 평균 : " + ( linuxSum / data.size() ) );
    }
    
    public static void main( String[] args ) {
        GradeCalculationV3        gcv3         = new GradeCalculationV3();
        List<Map<String, Object>> data         = new ArrayList<>();
        Map<String, Object>       studentScore = new HashMap<>();
        
        studentScore.put( "studentName", "이순신" );
        studentScore.put( "javaScore", 80 );
        studentScore.put( "dbScore", 75 );
        studentScore.put( "linuxScore", 70 );
        data.add( studentScore );
        
        studentScore = new HashMap<>();
        studentScore.put( "studentName", "강감찬" );
        studentScore.put( "javaScore", 90 );
        studentScore.put( "dbScore", 85 );
        studentScore.put( "linuxScore", 95 );
        data.add( studentScore );
        
        studentScore = new HashMap<>();
        studentScore.put( "studentName", "김춘추" );
        studentScore.put( "javaScore", 65 );
        studentScore.put( "dbScore", 60 );
        studentScore.put( "linuxScore", 60 );
        data.add( studentScore );
        
        gcv3.calc( data );
    }
}
