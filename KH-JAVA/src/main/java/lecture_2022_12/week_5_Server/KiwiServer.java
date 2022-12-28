package lecture_2022_12.week_5_Server;

import javax.swing.JFrame;

@SuppressWarnings( "serial" )
public class KiwiServer extends JFrame implements Runnable {
    
    public KiwiServer() {
        System.out.println( "Kiwi default constructor" );
    }
    
    public void initDisplay() {
        this.setTitle( "키위톡" );
        this.setVisible( true );
        this.setSize( 500, 400 );
    }
    
    public static void main( String[] args ) {
        KiwiServer ks = new KiwiServer();
        ks.initDisplay();
        Thread th = new Thread( ks );
        th.start();
    }
    
    @Override
    public void run() {
        System.out.println( "run 호출 성공" );
        // 경합이 벌거지는 일 ,대기(지연)이 필요한 일
        // 일반 메서드로 처리할 때와 다른 점
        // 보장받는다. 늦게라도 실행된다. -일반 메서드는
        
    }
}
