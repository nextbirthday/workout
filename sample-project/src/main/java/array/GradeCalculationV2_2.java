package array;

import java.util.ArrayList;
import java.util.List;

public class GradeCalculationV2_2 {
    
    private void calc( List<StudentScore> data ) {
        
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
        System.out.println( "과목별 총점 및 평균\nJAVA 총점 : " + javaSum + ", 평균 : " + ( javaSum / data.size() ) + "\nDB 총점 : " + dbSum + ", 평균 : "
                        + ( dbSum / data.size() ) + "\nLinux 총점 : " + linuxSum + ", 평균 : " + ( linuxSum / data.size() ) );
    }
    
    public static void main( String[] args ) {
        GradeCalculationV2_2 gcv2 = new GradeCalculationV2_2();
        List<StudentScore>   data = new ArrayList<>();
        
        /*
         * V2_1과 다르게 StudentScore 클래스의 생성자(Constructor)를 오버로딩(Overloading)하여
         * 인스턴스를 생성하는 동시에 값을 초기화해줄 수 있다.
         * 인스턴스 생성과 동시에 변수(학생명, 점수 등)가 초기화되었으므로,
         * 별도로 setter 메서드를 호출하여 변수별로 값을 입력할 필요가 없어진다.
         * setter 메서드가 필요하지 않으므로, 인스턴스의 주솟값을 변수에 담아둘 필요도 없어진다(아래 대괄호친 부분).
         * [StudentScore 참조변수 =] new StudentScore( "이순신", 80, 75, 70 );
         * 그저 생성된 인스턴스의 주솟값만 바로 List의 요소(Element)로 넣어버리면 되기 때문에
         * 아래와 같이 간결하게 사용할 수 있다.
         * 물론 실제 DB에서 가져온 데이터를 이런식으로 저장하지는 않으므로,
         * '인스턴스 주솟값을 굳이 참조변수에 넣을 필요도 없을 때가 있다.' 정도로만 알아두면 된다.
         */
        data.add( new StudentScore( "이순신", 80, 75, 70 ) );
        data.add( new StudentScore( "강감찬", 90, 85, 95 ) );
        data.add( new StudentScore( "김춘추", 65, 60, 60 ) );
        gcv2.calc( data );
    }
}
