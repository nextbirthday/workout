package lecture_2023_01.week_1_Chat;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class FileTest {
    
    public void output() {
        
        FileWriter fw = null;
        
        try {
            fw = new FileWriter( "test.txt", true );
            fw.write( 65 );
            fw.write( 66 );
            fw.write( 67 );
            fw.write( 68 );
            fw.write( 69 );
            // IO 패키지는 스트림형태로 이동하니까 열려있을 경우 인터셉트나 위,변조가 가능하므로 반드시 사용후에 닫아야한다.
        }
        catch ( FileNotFoundException fe ) {
            
        }
        
        catch ( IOException ie ) {
            ie.printStackTrace();
        }
        
        finally {
            
            // 예외가 발생하든 발생하지 않든 무조건 처리할 코드는 finally block 안에 작성
            try {
                if ( fw != null )
                    fw.close();
            }
            catch ( Exception e2 ) {}
        }
        
    }
    
    public static void main( String[] args ) {
        FileTest ft = new FileTest();
        ft.output();
    }
}
