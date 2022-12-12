package b3_1212;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AddressBook implements ActionListener {
    
    @Override
    public void actionPerformed( ActionEvent e ) {
        Object obj = e.getSource();
        
        if ( obj == searchButton ) {
            aDialog.jdg.setVisible( true );
        }
        else if ( obj == insertButton ) {
            aDialog.jdg.setVisible( true );
        }
        else if ( obj == modifyButton ) {
            aDialog.jdg.setVisible( true );
        }
        else if ( obj == detailButton ) {
            aDialog.jdg.setVisible( true );
        }
    }
    
    // field
    AddressDialog aDialog = new AddressDialog( this );
    
    JFrame  jf           = new JFrame( "AddressBook ver 1.0" );
    JButton searchButton = new JButton( "조회" );
    JButton insertButton = new JButton( "입력" );
    JButton modifyButton = new JButton( "수정" );
    JButton detailButton = new JButton( "상세보기" );
    
    // constructor
    public AddressBook() {
        initDisplay();
    }
    
    // view method
    void initDisplay() {
        
        JPanel jp_north  = new JPanel();
        JPanel jp_center = new JPanel();
        
        jf.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        
        jp_north.setLayout( new FlowLayout( 0 ) );
        
        jf.add( "North", jp_north );
        jf.add( "Center", jp_center );
        
        jp_center.setBackground( Color.ORANGE );
        
        jp_north.add( searchButton );
        jp_north.add( insertButton );
        jp_north.add( modifyButton );
        jp_north.add( detailButton );
        
        searchButton.addActionListener( this );
        insertButton.addActionListener( this );
        modifyButton.addActionListener( this );
        detailButton.addActionListener( this );
        
        jf.setSize( 600, 500 );
        jf.setVisible( true );
    }
    
    public static void main( String[] args ) {
        new AddressBook();
    }
    
}
