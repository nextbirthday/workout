package lecture_2022_12.week_5_URL_Tomcat;

import java.net.MalformedURLException;
import java.net.URL;

public class TomcatSetver {
    public static void main( String[] args ) {
        String url = "http://192.168.10.47:9000/index.html";
        
        try { // 예외가 발생할 가능성이 있는 코드
            URL myURL = new URL( url );
        }
        catch ( MalformedURLException e ) {
            e.printStackTrace();
        }
    }
}
