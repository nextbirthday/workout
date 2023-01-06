package OnionTalk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


@SuppressWarnings( "serial" )
public class ChatRoomView extends JFrame implements ActionListener {
    
    JPanel      centerPanel   = new JPanel();
    JPanel      southPanel    = new JPanel();
    JButton     sendButton    = new JButton( "전송" );
    JTextField  chatTextField = new JTextField( 20 );
    JTextArea   chatDisplay   = new JTextArea( 15, 38 );
    JScrollPane scrollPane    = new JScrollPane( chatDisplay, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
    
    public ChatRoomView() {}
    
    public ChatRoomView( boolean isView ) {
        initChatRoomView( isView );
    }
    
    public void initChatRoomView( boolean isView ) {
        centerPanel.setLayout( new BorderLayout() );
        centerPanel.add( "Center", scrollPane );
        centerPanel.add( "South", southPanel );
        
        southPanel.setLayout( new BorderLayout() );
        southPanel.add( "Center", chatTextField );
        southPanel.add( "East", sendButton );
        chatDisplay.setLineWrap( true );// 자동줄바꾸기
        chatDisplay.setEditable( false );
        chatDisplay.setBackground( Color.cyan );
        chatTextField.addActionListener( this );
        sendButton.addActionListener( this );
        this.setLayout( new GridLayout( 1, 2 ) );
        this.add( centerPanel );
        this.setTitle( "nickname" );
        this.setVisible( isView );
        this.setSize( 400, 600 );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
    }
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object object = e.getSource();
        
        if ( chatTextField == object || sendButton == object ) {
            String message = chatTextField.getText();
            chatDisplay.append( message + "\n" );
            chatTextField.setText( "" );
        }
    }
    
    public static void main( String[] args ) {
        ChatRoomView test = new ChatRoomView( true );
    }
}
