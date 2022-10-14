package classpart;

public class StudentTest {
    
public static void main(String[] args) {
        
        Student studentLee = new Student();
        studentLee.studentName = "이순신";
        studentLee.studentID = 100;
        studentLee.address = "서울특별시 서초구 방배동";
    
        Student studentK = new Student();
        studentK.studentName = "김보통";
        studentK.studentID = 101;
        studentK.address = "서울특별시 서초구 반포동";
        
        
        studentLee.showStudentInfor();
        studentK.showStudentInfor();
        
        System.out.println( studentLee );
        System.out.println( studentK );
    }
    
    
}
