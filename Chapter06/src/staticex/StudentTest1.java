package staticex;

public class StudentTest1 {
    
    public static void main( String[] args ) {
        System.out.println( Student.getSerialNum() );
        
        Student studentC = new Student();
        System.out.println( studentC.getSerialNum() );
        
        
        Student studentV = new Student();
        System.out.println( studentV.studentID );
        
        
        
    }
    
}
