package lecture_2022_12.week_4_NetWork;

import javax.swing.JFrame;

@SuppressWarnings( "serial" )
public class ThreadEx02 extends JFrame {
    public ThreadEx02() {
        super( "JFrame Test - in 5seconds close" );
        this.setSize( 500, 400 );
        this.setVisible( true );
        
        // 대기
        try {
            Thread.sleep( 5000 );
        }
        catch ( InterruptedException ie ) {
            ie.printStackTrace();
        }
        setVisible( false );
    }
    
    public static void main( String[] args ) {
        new ThreadEx02(); // 생성자 호출
        
    }
    
}
