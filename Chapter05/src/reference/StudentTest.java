package reference;

public class StudentTest {
    
    public static void main( String[] args ) {

        Student studentJames = new Student(100, "James");
        studentJames.setKorea( "언어", 100 );
        studentJames.setMath( "수학", 100 );
        
        Student studentChris = new Student(101, "Chris");
        studentChris.setKorea( "언어", 90 );
        studentChris.setMath( "수학", 70 );
        
        studentJames.showStudentInfo();
        studentChris.showStudentInfo();
    }
    
}
