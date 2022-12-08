package conditional;

public class Conditional {
    
    public void testIf(int kor, int math, int eng) { // parameter 활용
            
        int    sum = kor + math + eng;
        double avg = sum / 3.0;
        
        System.out.println( "합계:" + sum );
        System.out.println( "평균:" + avg );
        
        // if문
        if ( avg >= 60 ) {
            System.out.println( "합격" );
        }
        // else
        else {
            System.out.println( "불합격" );
        }
        
        // if-else if-else
        if ( avg >= 60 ) {
            System.out.println( "합격" );
        }
        else if ( avg >= 40 ) {
            System.out.println( "보충 수업" );
        } // &&avg<60표기를 안하는 이유 이미 if문에서 거름
        else {
            System.out.println( "불합격" );
        }
        // 중첩 if문
        
        String grade = "";
        
        if ( kor >= 80 ) {
            grade = "A";
            
            if ( kor >= 95 ) {
                grade += "+"; // grade = grade + "+"
            }
            else if ( kor >= 85 ) {
                grade += "0";
            }
            else {
                grade += "-";
            }
        }
        else if ( kor >= 60 ) {
            grade = "B";
        }   // 75점 이상이면 B+, 65점 이상이면 B0, 나머지 B-
        else {
            grade = "C";
        }   // 55점 이상이면 C+, 45점 이상이면 C0
        
        System.out.println( "국어 성적은" + grade + "입니다." );
        
    }
    
}
