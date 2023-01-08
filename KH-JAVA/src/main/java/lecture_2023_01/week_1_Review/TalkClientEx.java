package lecture_2023_01.week_1_Review;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TalkClientEx {
    
    public TalkClientEx() {}
    
    Socket         socket;
    BufferedReader in;
    BufferedWriter out;
    Scanner        scanner = new Scanner( System.in );
    
    protected void init() {
        boolean isStop = false;
        
        try {
            socket = new Socket( "localhost", 9999 );
            
            in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );
            out = new BufferedWriter( new OutputStreamWriter( socket.getOutputStream() ) );
            
            while ( !isStop ) {
                
                System.out.print( "Send >>>" );
                String outMessage = scanner.nextLine();
                
                if ( outMessage.equalsIgnoreCase( "Bye" ) ) {
                    out.write( outMessage + "\n" );
                    out.flush();
                    break;
                }
                
                out.write( outMessage + "\n" );
                out.flush();
                
                String inMessage = in.readLine();
                // 정상적인 message의 경우
                System.out.println( "From Server : " + inMessage );
                
            }
        }
        catch ( UnknownHostException e ) {
            e.printStackTrace();
        }
        catch ( IOException e ) {
            e.printStackTrace();
        }
        finally {
            
            try {
                scanner.close();
                out.close();
                in.close();
                socket.close();
            }
            catch ( IOException e ) {
                e.printStackTrace();
            }
        }
        
    }
    
    public static void main( String[] args ) {
        TalkClientEx tc = new TalkClientEx();
        tc.init();
    }
    
}
