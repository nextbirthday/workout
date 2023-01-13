package lecture_2023_01.week_2_view;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings( "serial" )
public class KiwiApp extends JFrame implements ActionListener {
    String      imgPath  = "C:\\Users\\HOJAE\\Desktop\\images\\";
    Image[]     img;
    ImageIcon[] imgs     = new ImageIcon[3];
    String[]    imgNames = { "admin2.png", "broken2.png", "point2.png" };
    
    JPanel jp_south  = new JPanel();
    JPanel jp_center = new JPanel();
    
    JButton jbtn1       = new JButton();
    JButton jbtn2       = new JButton();
    JButton jbtn3       = new JButton();
    JButton imgButton[] = { jbtn1, jbtn2, jbtn3 };
    // Container 클래스는 JFrame에서만 주입 받을 수 있다.JPanel에서는 생성이 불가능하다.
    // 생성자 파라미터를 통해 넘겨서 사용한다.
    Container  conn = this.getContentPane();
    KiwiPanel1 kiwiPanel1;
    KiwiPanel2 kiwiPanel2;
    KiwiPanel3 kiwiPanel3;
    
    public KiwiApp() {}
    
    public void initDisplay() {
        
        jp_center.setBackground( Color.cyan );
        jp_south.setBackground( Color.MAGENTA );
        jp_south.setLayout( new GridLayout( 1, 3 ) );
        jp_south.add( jbtn1 );
        jp_south.add( jbtn2 );
        jp_south.add( jbtn3 );
        jbtn1.addActionListener( this );
        jbtn2.addActionListener( this );
        jbtn3.addActionListener( this );
        
        for ( int i = 0; i < imgs.length; i++ ) {
            imgs[i] = new ImageIcon( imgPath + imgNames[i] );
            imgButton[i].setIcon( imgs[i] );
            imgButton[i].setBorderPainted( false );
            imgButton[i].setFocusPainted( false ); // 누르면 선이 보이는 것
            imgButton[i].setContentAreaFilled( false );
            jp_south.add( imgButton[i] );
        }
        this.add( "South", jp_south );
        this.add( "Center", jp_center );
        this.setSize( 400, 600 );
        this.setVisible( true );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
    
    public static void main( String[] args ) {
        KiwiApp app = new KiwiApp();
        app.initDisplay();
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        if ( object == jbtn1 ) {
            System.out.println( "jbtn1" );
            
            if ( kiwiPanel2 != null ) {
                conn.remove( kiwiPanel2.jta );
                conn.remove( kiwiPanel2.jtf );
                conn.remove( kiwiPanel2 );
            }
            
            if ( kiwiPanel3 != null ) {
                conn.remove( kiwiPanel3.scrollPane );
                conn.remove( kiwiPanel3 );
            }
            
            kiwiPanel1 = new KiwiPanel1();
            this.add( "Center", kiwiPanel1 );
            conn.revalidate();
        }
        else if ( object == jbtn2 ) {
            System.out.println( "jbtn2" );
            
            if ( kiwiPanel1 != null ) {
                conn.remove( kiwiPanel1.jbtn1 );
                conn.remove( kiwiPanel1.jbtn2 );
                conn.remove( kiwiPanel1.jbtn3 );
                conn.remove( kiwiPanel1 );
            }
            
            if ( kiwiPanel3 != null ) {
                conn.remove( kiwiPanel3.scrollPane );
                conn.remove( kiwiPanel3 );
            }
            kiwiPanel2 = new KiwiPanel2();
            this.add( "Center", kiwiPanel2 );
            conn.revalidate();
        }
        else if ( object == jbtn3 ) {
            System.out.println( "jbtn3" );
            
            if ( kiwiPanel1 != null ) {
                conn.remove( kiwiPanel1.jbtn1 );
                conn.remove( kiwiPanel1.jbtn2 );
                conn.remove( kiwiPanel1.jbtn3 );
                conn.remove( kiwiPanel1 );
            }
            
            if ( kiwiPanel2 != null ) {
                conn.remove( kiwiPanel2.jta );
                conn.remove( kiwiPanel2.jtf );
                conn.remove( kiwiPanel2 );
            }
            kiwiPanel3 = new KiwiPanel3();
            this.add( "Center", kiwiPanel3 );
            conn.revalidate();
        }
    }
    
}
