package lecture_2022_12.week_4_Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings( "serial" )
class Button1 extends JFrame {
    
    Button1Event button1Event = new Button1Event( this );
    
    public Button1( Button1Event buttonEvent ) {}
    
    JButton insertButton = null; // 선언만 했다.
    JButton updateButton = new JButton( "수정" ); // 선언 및 생성 동시에 생성자 호출까지 일어났다.
    JPanel  eastPanel    = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();
    
    public Button1() {
        // constructor 안에서 JButton Object를 생성하면 어떻게 될까 - 시점에 따라 NullPointerException
        System.out.println( "initDisplay 호출 후" + " " + ( insertButton == null ) );
        
        insertButton = new JButton( "입력" );
        System.out.println( " insertButton 생성 후" + " " + ( insertButton == null ) );
        
        initDisplay(); // new Button1()이 호출되면 자동을 호출이 일어난다.
    }
    
    public void initDisplay() {
        JButton deleteButton = new JButton( "삭제" );
        
        // northPanel.add( insertButton );
        // southPanel.add( updateButton );
        // eastPanel.add( deleteButton );
        
        if ( insertButton != null ) {
            this.add( "North", insertButton );
        }
        insertButton.addActionListener( button1Event );
        updateButton.addActionListener( button1Event );
        // this.add( "North", insertButton );
        this.add( "South", updateButton );
        this.add( "East", deleteButton );
        // this.add( "North", northPanel );
        // this.add( "South", southPanel );
        // this.add( "East", eastPanel );
        this.setSize( 600, 500 );
        this.setVisible( true );
        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    }
}

class Button1Event implements ActionListener {
    
    Button1 button1 = null;
    
    public Button1Event( Button1 button1 ) {
        this.button1 = button1;
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        if ( object == button1.insertButton ) {
            System.out.println( "insert" );
        }
    }
}

public class Buttom1Main {
    
    public static void main( String[] args ) {
        Button1 button1 = new Button1();
    }
    
}
