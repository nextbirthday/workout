package grade;

import java.util.ArrayList;
import java.util.List;

public class Student {
    
    public Student() {}
    
    public Student( String studentName ) {
        this.studentName = studentName;
    }
    
    private String        studentName;
    private List<Subject> subjectList = new ArrayList<>();
    
    public String getStudentName() { return studentName; }
    
    public void setStudentName( String studentName ) { this.studentName = studentName; }
    
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
