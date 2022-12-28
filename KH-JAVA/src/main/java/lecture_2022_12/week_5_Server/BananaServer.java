package lecture_2022_12.week_5_Server;

import javax.swing.JFrame;

@SuppressWarnings( "serial" )
public class BananaServer extends JFrame {
    
    public BananaServer() {
        // initDisplay();
    }
    
    public BananaServer( String title ) {
        super( title );
        initDisplay();
        // 아래의 this는 BananaServer를 가리키는 것임
        // this.(title);
    }
    
    public void initDisplay() {
        this.setVisible( true );
        this.setSize( 500, 400 );
    }
    
    // this는 클래스 쪼개기 즉 view와 logic의 분리 또는 하나의 클래스를 여러개의 클래스로 나누어 (분업)처리할 때만 필요하다.
    
    public static void main( String[] args ) {
        // constructor parameter에는 this 말고도 다른 type을 사용 가능하다.
        new BananaServer( "생성자 파라미터로 제목을 결정함 - 초기화" );
        // BananaServer bs = new BananaServer();
        // bs.initDisplay();
    }
}

/*
 * initDisplay를 메인메서드에서 호출하는 것과 생성자 안에서 호출하는 것이 가능하다. 그렇다면 둘의 차이는? 키위톡은 메인메서드에서
 * initDisplay 호출함 바나나톡은 생성자에서 initDisplay 호출함
 */
