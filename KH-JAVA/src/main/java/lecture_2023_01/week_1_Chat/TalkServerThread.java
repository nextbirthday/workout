package lecture_2023_01.week_1_Chat;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread {
    
    TalkServer         ts;
    Socket             client = null;
    ObjectOutputStream oos    = null;
    ObjectInputStream  ois    = null;
    
    String chatName = null;
    
    public TalkServerThread() {}
    
    public TalkServerThread( TalkServer ts ) {
        this.ts = ts;
        this.client = ts.socket;
        
        try {
            oos = new ObjectOutputStream( client.getOutputStream() );
            ois = new ObjectInputStream( client.getInputStream() );
            String message = ( String ) ois.readObject();
            ts.logTextArea.append( message + "\n" );
            StringTokenizer st = new StringTokenizer( message, "#" );
            st.nextToken();
            chatName = st.nextToken();
            ts.logTextArea.append( chatName + "님이 입장하셨습니다.\n" );
            
            for ( TalkServerThread tst : ts.tstList ) {
                this.send( ChatProtocol.TALK_IN + ChatProtocol.separator + tst.chatName );
            }
            // 현재 서버에 입장한 client thread 추가하기
            ts.tstList.add( this );
            this.broadCasting( message );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void run() {}
    
    // 현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
    public void broadCasting( String message ) {
        
        for ( TalkServerThread tst : ts.tstList ) {
            tst.send( message );
        }
    }
    
    // 클라이언트에게 말하기 구현
    public void send( String message ) {
        
        try {
            oos.writeObject( message );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
