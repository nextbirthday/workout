package lecture_2023_01.week_2_view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings( "serial" )
public class KiwiPanel2 extends JPanel implements ActionListener {
    JTextArea  jta = new JTextArea( "" );
    JTextField jtf = new JTextField( "" );
    KiwiApp    kiwiApp;
    
    public KiwiPanel2() {
        initDisplay();
    }
    
    public KiwiPanel2( KiwiApp kiwiApp ) {
        this(); // 18번 default constructor call
        this.kiwiApp = kiwiApp;
    }
    
    public void initDisplay() {
        
        // JPanel은 디폴트 레이아웃이 플로우 레이아웃
        if ( KiwiPanel1.isSize ) {
            changeFontSize();
        }
        this.setLayout( new BorderLayout() );
        this.add( "Center", jta );
        this.add( "South", jtf );
        jtf.requestFocus( true );
        jtf.addActionListener( this );
    }
    
    public void changeFontSize() {
        jta.setFont( KiwiPanel1.font );
        jtf.setFont( KiwiPanel1.font );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        if ( object == jtf ) {
            String message = jtf.getText();
            jta.append( message + "\n" );
            
            if ( message.length() > 0 ) {
                jtf.setText( "" );
            }
        }
    }
    
}
