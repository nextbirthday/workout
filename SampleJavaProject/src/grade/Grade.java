package grade;

import com.google.gson.Gson;

public class Grade {
    
    public static void main( String[] args ) {
        Student kim = new Student( "KIM" );
        kim.setSubject( "KOREAN", 90 );
        kim.setSubject( "MATH", 88 );
        kim.setSubject( "SCIENCE", 67 );
        
        kim.getSubjectList();
        
        Gson   gson    = new Gson();
        String kimJson = gson.toJson( kim );
        System.out.println( kimJson );
        Student temp = gson.fromJson( kimJson, Student.class );
        temp.getSubjectList();
    }
}
