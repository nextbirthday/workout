package b3_1214;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
    
    Sub sub = new Sub( this );
    
    JFrame jf = new JFrame();
    
    public Main() {
        initDisplay();
        
    } // default constructor 안에서 화면을 그리는 initDisplay가 호출되고 있다.
      // 이 method는 화면을 그리는 method이다.
      // 화면이 두개 열린다????? -
    
    public void initDisplay() {
        System.out.println( "initDisplay call" );
        jf.setTitle( "Main" );
        jf.setSize( 400, 300 );
        jf.setVisible( true );
        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    
    public void refresh() {
        System.out.println( "refresh(); method call" );
        JOptionPane.showMessageDialog( jf, "새로고침 처리 되었습니다." );
    }
    
    public static void main( String[] args ) {
        // Main m1 = new Main();
        // initDisplay(); non-static method를 static area에서 call 불가
        // m1.initDisplay();
        
        new Main();
        // 인스턴스화를 했다. 
        // memory에 상주된다. - 변수나 메서드를 사용할 수 있는 상태
        
        // new Main().initDisplay(); 생성자 호출과 동시에 initDisplay(); method 호출        
    }    
}
