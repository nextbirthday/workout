package grade;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@RequiredArgsConstructor
public class Student {
    @Getter
    @Setter
    @NonNull
    private String        studentName; // 인스턴스 변수, 전역변수
    private List<Subject> subjectList = new ArrayList<>();
    
    // public void setSubjectList( List<Subject> subjectList ) { this.subjectList = subjectList; }
    
    public void setSubject( String subjectName, int score ) {
        subjectList.add( new Subject( subjectName, score ) );
    }
    
    public void getSubjectList() {
        double average = 0.0;
        int    total   = 0;
        
        for ( Subject subject : subjectList ) {
            System.out.println( subject.toString() );
            total += subject.getScore();
        }
        average = total / ( double ) subjectList.size();
        
        System.out.println( "average=" + Math.round( average * 100 ) / 100.0 );
    }
    
    @Override
    public String toString() {
        return "Student [studentName=" + studentName + ", subject=" + subjectList + "]";
    }
}
