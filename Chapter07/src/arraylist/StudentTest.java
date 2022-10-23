package arraylist;

public class StudentTest {
    
    public static void main( String[] args ) {
        
        Student studentLee = new Student( 1000, "Lee" );
        studentLee.addSubject( "언어", 100 );
        studentLee.addSubject( "수리", 80 );
        
        studentLee.showStudentInfo();
        
        System.out.println( "===========" );
        
        Student studentKim = new Student( 1001, "Kim" );
        studentKim.addSubject( "언어", 90 );
        studentKim.addSubject( "수리", 96 );
        studentKim.addSubject( "외국어", 88 );
        
        studentKim.showStudentInfo();
    }
    
}
