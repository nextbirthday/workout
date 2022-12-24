package lecture_2022_12.week_4_NetWork;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.StringTokenizer;

public class TalkServerThread extends Thread { //토크서버스레드가 클라이언트랑 연결된 하나의 회선 
    
    TalkServer         ts     = null;
    Socket             client = null;
    ObjectOutputStream oos    = null;
    ObjectInputStream  ois    = null;
    // 현재 서버에 입장한 클라이언트 스레드의 닉네임 저장
    String chatName = null;
    
    public TalkServerThread() {
        
    }
    
    public TalkServerThread( TalkServer ts ) {
        this.ts = ts;
        this.client = ts.socket;
        
        try {
            oos = new ObjectOutputStream( client.getOutputStream() ); // ObjectOutputStream - 말하기
            ois = new ObjectInputStream( client.getInputStream() ); // ObjectInputStream - 듣기 
            String message = ( String ) ois.readObject(); // 오브젝트 단위로 읽고 쓰는
            ts.jta_log.append( message + "\n" );
            StringTokenizer st = new StringTokenizer( message, "#" );
            st.nextToken(); // 100 skip처리
            chatName = st.nextToken(); // 토마토저장
            ts.jta_log.append( chatName + "님이 입장하였습니다.\n" );
            
            for ( TalkServerThread tst : ts.globalList ) {
                this.send( Protocol.TALK_IN + Protocol.separator + tst.chatName );
            }
            // 현재 서버에 입장한 클라이언트 스레드 추가하기
            ts.globalList.add( this );
            this.broadCasting( message );
        }
        catch ( Exception e ) {
            
        }
    }
    
    // 현재 입장해 있는 친구들 모두에게 메시지 전송하기 구현
    public void broadCasting( String message ) {
        
        for ( TalkServerThread tst : ts.globalList ) {
            tst.send( message ); // 34번 코드와의 차이점 설명....
        }
    }
    
    // 클라이언트에게 말하기 구현
    public void send( String message ) {
        
        try {
            oos.writeObject( message );
        }
        catch ( Exception e ) {
            e.printStackTrace(); // stack에 쌓여있는 error message log print
        }
    }
    
    @Override
    public void run() {
        
    }
}