package lecture_2023_01.week_1_Chat;

import java.io.IOException;
import java.util.StringTokenizer;

public class TalkClientThread extends Thread {
    TalkClient tc = null;
    
    public TalkClientThread() {}
    
    public TalkClientThread( TalkClient tc ) {
        this.tc = tc;
    }
    
    @Override
    public void run() {
        boolean isStop = false;
        
        while ( !isStop ) {
            String message = "";
            
            try {
                message = ( String ) tc.ois.readObject();
                System.out.println( "From server message : " + message );
                StringTokenizer st = null;
                int             protocol = 0;
            }
            catch ( ClassNotFoundException e ) {
                e.printStackTrace();
            }
            catch ( IOException e ) {
                e.printStackTrace();
            }
            
        }
    }
}
